package com.example.somestarwarsapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.somestarwarsapp.R
import com.example.somestarwarsapp.ui.composable.PersonShortBioItem
import com.example.somestarwarsapp.ui.navigation.Navigator
import com.example.somestarwarsapp.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel, navigator: Navigator) {

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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(colorResource(R.color.background))
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.secondary),
                        contentColor = colorResource(R.color.secondary)
                    ),
                    enabled = isPrevious,
                    onClick = { /*...*/ }
                ) {
                    Text(
                        "Previous Page",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp, // kleiner als 24.sp
                        color = colorResource(if (isPrevious) R.color.accent else R.color.secondary)
                    )
                }

                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.secondary),
                        contentColor = colorResource(R.color.secondary)
                    ),
                    enabled = isNext,
                    onClick = { /*...*/ }
                ) {
                    Text(
                        "Next Page",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = colorResource(if (isNext) R.color.accent else R.color.secondary)
                    )
                }
            }
        }
        items(
            items = uiState.peopleViewData?.results.orEmpty(),
            key = { it.id }) {
            PersonShortBioItem(
                name = it.name,
                birthYear = it.birthYear,
                gender = it.gender,
                homeworld = it.homeworld.orEmpty(),
                films = it.films,
              //  onClick = { navigator.navigateToPersonDetails(it.id) }
            )
        }
    }
}