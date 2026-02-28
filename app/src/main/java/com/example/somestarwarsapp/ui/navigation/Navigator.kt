package com.example.somestarwarsapp.ui.navigation

import androidx.compose.runtime.mutableStateListOf

class Navigator(startDestination: Route) {
    val backstack = mutableStateListOf(startDestination)

    fun goTo(destination: Route) {
        backstack.add(destination)
    }

    fun goBack() {
        backstack.removeLastOrNull()
    }
}