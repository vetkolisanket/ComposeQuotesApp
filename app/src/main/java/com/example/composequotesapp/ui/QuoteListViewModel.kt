package com.example.composequotesapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composequotesapp.asState
import com.example.composequotesapp.domain.use_case.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteListViewModel @Inject constructor(val getQuotesUseCase: GetQuotesUseCase) : ViewModel() {

    private val _quoteListState = mutableStateOf<QuoteListState>(QuoteListState(emptyList()))
    val quoteListState = _quoteListState.asState()

    init {
        fetchQuotes()
    }

    private fun fetchQuotes() {
        viewModelScope.launch {
            getQuotesUseCase().collect {
                _quoteListState.value = quoteListState.value.copy(
                    quotes = it
                )
            }
        }
    }

}