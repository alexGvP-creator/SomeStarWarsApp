package com.example.somestarwarsapp.ui.screen.home

import com.example.somestarwarsapp.ui.model.PeopleViewData

data class HomeScreenUiState(
    val isLoading: Boolean = false,
    val currentPage: Int = 1,
    val peopleViewData: PeopleViewData? = null,
    val isError: Boolean = false,
)