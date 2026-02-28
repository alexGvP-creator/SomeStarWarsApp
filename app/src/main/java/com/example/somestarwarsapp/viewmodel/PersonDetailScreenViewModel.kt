package com.example.somestarwarsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.somestarwarsapp.ui.model.PersonViewData
import com.example.somestarwarsapp.ui.screen.persondetail.PersonDetailScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PersonDetailScreenViewModel(personViewData: PersonViewData) : ViewModel() {

    private val _uiState = MutableStateFlow(
        PersonDetailScreenUiState(
            personViewData = personViewData
        )
    )
    val uiState: StateFlow<PersonDetailScreenUiState> = _uiState.asStateFlow()
}