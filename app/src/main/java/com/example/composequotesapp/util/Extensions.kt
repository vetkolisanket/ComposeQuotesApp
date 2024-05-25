package com.example.composequotesapp.util

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State

fun <T> MutableState<T>.asState(): State<T> {
    return this
}