package com.example.composequotesapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.composequotesapp.R
import com.example.composequotesapp.models.Quote

@Composable
fun QuoteList(data: List<Quote>, onClick: (quote: Quote) -> Unit) {
    if (data.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.loading),
                style = MaterialTheme.typography.titleLarge
            )
        }
    } else {
        LazyColumn {
            items(data.size) {
                QuoteListItem(quote = data[it], onClick)
            }
        }
    }
}