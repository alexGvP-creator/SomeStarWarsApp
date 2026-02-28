package com.example.somestarwarsapp.ui.screen.persondetail

import com.example.somestarwarsapp.ui.model.PersonViewData

data class PersonDetailScreenUiState(
    val isLoading: Boolean = false,
    val personViewData: PersonViewData,
)