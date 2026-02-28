package com.example.somestarwarsapp.ui.navigation

import androidx.navigation3.runtime.NavKey
import com.example.somestarwarsapp.ui.model.PersonViewData
import kotlinx.serialization.Serializable

@Serializable
sealed class Route : NavKey {

    @Serializable
    data object HomeRoute : Route()

    @Serializable
    data class PersonDetailRoute(val personViewData: PersonViewData) : Route()
}

