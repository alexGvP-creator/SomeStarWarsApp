package com.example.somestarwarsapp.ui.navigation

import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf

class Navigator(startDestination: Route) {
    val backstack = mutableStateListOf(startDestination)

    fun goTo(destination: Route, toast: Toast) {
        toast.show()
        backstack.add(destination)
    }

    fun goBack() {
        backstack.removeLastOrNull()
    }

}