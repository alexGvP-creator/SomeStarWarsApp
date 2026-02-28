package com.example.somestarwarsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.somestarwarsapp.domain.model.ApiResult
import com.example.somestarwarsapp.domain.model.PeopleData
import com.example.somestarwarsapp.domain.repository.StarWarsApiRepository
import com.example.somestarwarsapp.ui.mapper.PeopleViewDataMapper
import com.example.somestarwarsapp.ui.screen.home.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val repository: StarWarsApiRepository,
    private val peopleViewDataMapper: PeopleViewDataMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch { // TODO refactor -> here are two viewModelScope launch for api call
            uiState.map { it.currentPage }
                .distinctUntilChanged()
                .collect { page ->
                    fetchPeople(page)
                }
        }
    }

    fun fetchPeople(page: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val result = repository.fetchPeople(page)
            if (result is ApiResult.Success && result.data is PeopleData) {
                val peopleData = result.data
                _uiState.update {
                    it.copy(
                        isError = false,
                        peopleViewData = peopleViewDataMapper.mapPeopleViewData(peopleData),
                        currentPage = page
                    )
                }
            } else {
                _uiState.update { it.copy(isError = true) }
            }
            _uiState.update { it.copy(isLoading = false) }
        }
    }
}

