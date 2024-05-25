package com.example.composequotesapp.core

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composequotesapp.models.Quote
import com.example.composequotesapp.ui.screens.QuoteDetailScreen
import com.example.composequotesapp.ui.screens.QuoteListScreen

sealed class Screen(val name: String) {
    data object QuoteList : Screen("quote-list")
    data object QuoteDetails : Screen("quote-details")
}

@Composable
fun QuotesAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.QuoteList.name) {
        composable(Screen.QuoteList.name) {
            QuoteListScreen(onQuoteClick = fun(quote: Quote) {
                navController.navigate(Screen.QuoteDetails.name + "?quoteText=${quote.text}")
            })
        }
        composable(
            route = Screen.QuoteDetails.name + "?quoteText={quoteText}",
            arguments = listOf(
                navArgument(
                    name = "quoteText",
                ) {
                    type = NavType.StringType
                }
            )
        ) {
            QuoteDetailScreen()
        }
    }
}