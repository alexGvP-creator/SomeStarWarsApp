package com.example.somestarwarsapp.ui.navigation

import androidx.navigation3.runtime.NavKey

sealed class Route : NavKey {

    data object HomeRoute : Route()

    data class PersonView(val id: Int) : Route()
}

