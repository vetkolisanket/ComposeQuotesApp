package com.example.composequotesapp.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composequotesapp.asState
import com.example.composequotesapp.domain.use_case.GetQuoteUseCase
import com.example.composequotesapp.models.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getQuoteUseCase: GetQuoteUseCase
) : ViewModel() {

    private val _quoteState = mutableStateOf<Quote?>(null)
    val quoteState = _quoteState.asState()

    init {
        savedStateHandle.get<String>("quoteText")?.let { quoteText ->
            viewModelScope.launch {
                getQuoteUseCase(quoteText).collect { quote ->
                    _quoteState.value = quote
                }
            }
        }
    }

}