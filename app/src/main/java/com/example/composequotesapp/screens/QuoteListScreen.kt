package com.example.composequotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composequotesapp.R
import com.example.composequotesapp.models.Quote
import com.example.composequotesapp.ui.QuoteListViewModel

@Composable
fun QuoteListScreen(
    viewModel: QuoteListViewModel = hiltViewModel(),
    onQuoteClick: (quote: Quote) -> Unit
) {
    val data = viewModel.quoteListState.value
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineMedium,
            fontFamily = FontFamily(Font(R.font.montserrat_semibold))
        )
        QuoteList(data = data.quotes, onQuoteClick)
    }
}