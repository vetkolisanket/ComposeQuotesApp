package com.example.composequotesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.composequotesapp.models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn {
        items(data.size) {
            QuoteListItem(quote = data[it], onClick)
        }
    }
}