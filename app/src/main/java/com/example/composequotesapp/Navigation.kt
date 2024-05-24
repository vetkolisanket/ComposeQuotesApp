package com.example.composequotesapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composequotesapp.screens.QuoteListScreen

sealed class Screen(val name: String) {
    data object QuoteList: Screen("quote-list")
    data object QuoteDetails: Screen("quote-details")
}

@Composable
fun QuotesAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.QuoteList.name) {
        composable(Screen.QuoteList.name) { 
            QuoteListScreen {
                
            }
        }
    }
}