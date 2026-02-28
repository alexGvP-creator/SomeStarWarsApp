package com.example.somestarwarsapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.somestarwarsapp.R
import com.example.somestarwarsapp.ui.model.PersonViewData
import com.example.somestarwarsapp.ui.screen.home.composable.LoadingItem
import com.example.somestarwarsapp.ui.screen.home.composable.PageNavigation
import com.example.somestarwarsapp.ui.screen.home.composable.PersonShortBioItem
import com.example.somestarwarsapp.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, onPersonDetailClick: (PersonViewData) -> Unit) {

    val uiState by viewModel.uiState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.background)),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        stickyHeader {
            val isNext = uiState.peopleViewData?.next != null
            val isPrevious = uiState.peopleViewData?.previous != null
            val currentPage = uiState.currentPage

            PageNavigation(
                isLoading = uiState.isLoading,
                isNext = isNext,
                isPrevious = isPrevious,
                onPreviousClick = { viewModel.fetchPeople(currentPage - 1) },
                onNextClick = { viewModel.fetchPeople(currentPage + 1) }
            )
        }

        if (uiState.isLoading) {
            item {
                LoadingItem()
            }
        } else {

            items(
                items = uiState.peopleViewData?.results.orEmpty(),
                key = { it.url }) {
                PersonShortBioItem(
                    name = it.name,
                    birthYear = it.birthYear,
                    gender = it.gender,
                    onClick = { onPersonDetailClick(it) }
                )
            }
        }
    }
}