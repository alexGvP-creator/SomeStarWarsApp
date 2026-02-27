package com.example.somestarwarsapp.ui.model

import kotlinx.serialization.Serializable

@Serializable
data class PeopleViewData(
    val next: String?,
    val previous: String?,
    val results: List<PersonViewData>
)