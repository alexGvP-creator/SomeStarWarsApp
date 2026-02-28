package com.example.somestarwarsapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.somestarwarsapp.R
import com.example.somestarwarsapp.ui.model.PersonViewData
import com.example.somestarwarsapp.ui.screen.home.composable.LoadingItem
import com.example.somestarwarsapp.ui.screen.home.composable.PageNavigation
import com.example.somestarwarsapp.ui.screen.home.composable.PersonShortBioItem
import com.example.somestarwarsapp.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    onPersonDetailClick: (PersonViewData) -> Unit,
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uiState.collectAsState()
    if (uiState.isError) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                color = colorResource(R.color.accent),
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                text = "Something went wrong..."
            )
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.secondary),
                    contentColor = colorResource(R.color.secondary)
                ),
                onClick = { viewModel.fetchPeople(uiState.currentPage) }
            ) {
                Text(
                    "Try Again",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = colorResource(R.color.accent)
                )
            }
        }
    } else {
        LazyColumn(
            modifier = modifier
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
}