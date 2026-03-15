package com.example.somestarwarsapp.ui.screen.persondetail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.somestarwarsapp.R
import com.example.somestarwarsapp.ui.model.PersonViewData
import com.example.somestarwarsapp.viewmodel.PersonDetailScreenViewModel

@Composable
fun PersonDetailScreen(
    viewModel: PersonDetailScreenViewModel,
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uiState.collectAsState()
    var showBottomSheet by rememberSaveable { mutableStateOf(false) }

    PersonDetailContent(
        modifier = modifier,
        uiState = uiState,
        showBottomSheet = showBottomSheet,
        onToggleBottomSheet = {
            showBottomSheet = !showBottomSheet
        },
        onDismissBottomSheet = {
            showBottomSheet = false
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PersonDetailContent(
    uiState: PersonDetailScreenUiState,
    showBottomSheet: Boolean,
    onToggleBottomSheet: () -> Unit,
    onDismissBottomSheet: () -> Unit,
    modifier: Modifier = Modifier
) {
    val personData = uiState.personViewData
    val sheetState = rememberModalBottomSheetState()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.secondary))
            .padding(28.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            color = colorResource(R.color.accent),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            text = personData.name
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                color = colorResource(R.color.off_white),
                fontSize = 16.sp,
                text = "Species: "
            )
            personData.species.forEach { race ->
                Text(
                    color = colorResource(R.color.white),
                    fontSize = 16.sp,
                    text = race
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = colorResource(R.color.off_white),
                fontSize = 16.sp,
                text = "Gender: "
            )
            Text(
                color = colorResource(R.color.white),
                fontSize = 16.sp,
                text = personData.gender
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = colorResource(R.color.off_white),
                fontSize = 16.sp,
                text = "Birth Year: "
            )
            Text(
                color = colorResource(R.color.white),
                fontSize = 16.sp,
                text = personData.birthYear
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = colorResource(R.color.off_white),
                fontSize = 16.sp,
                text = "Height: "
            )
            Text(
                color = colorResource(R.color.white),
                fontSize = 16.sp,
                text = personData.height
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = colorResource(R.color.off_white),
                fontSize = 16.sp,
                text = "Mass: "
            )
            Text(
                color = colorResource(R.color.white),
                fontSize = 16.sp,
                text = personData.mass
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = colorResource(R.color.off_white),
                fontSize = 16.sp,
                text = "Eye Color: "
            )
            Text(
                color = colorResource(R.color.white),
                fontSize = 16.sp,
                text = personData.eyeColor
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                color = colorResource(R.color.off_white),
                fontSize = 16.sp,
                text = "Hair Color: "
            )
            Text(
                color = colorResource(R.color.white),
                fontSize = 16.sp,
                text = personData.hairColor
            )
        }

        Text(
            text = "SHOW EXTENDED DATA",
            color = colorResource(R.color.accent),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onToggleBottomSheet)
        )
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = colorResource(R.color.background),
            onDismissRequest = onDismissBottomSheet,
            sheetState = sheetState
        ) {
            Column(
                modifier
                    .fillMaxSize()
                    .padding(28.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        color = colorResource(R.color.off_white),
                        fontSize = 16.sp,
                        text = "Homeworld: "
                    )
                    Text(
                        color = colorResource(R.color.white),
                        fontSize = 16.sp,
                        text = personData.homeworld
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        color = colorResource(R.color.off_white),
                        fontSize = 16.sp,
                        text = "Starships: "
                    )
                    personData.starships.forEach { ship ->
                        Text(
                            color = colorResource(R.color.white),
                            fontSize = 16.sp,
                            text = ship
                        )
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        color = colorResource(R.color.off_white),
                        fontSize = 16.sp,
                        text = "Movies: "
                    )
                    personData.films.forEach { film ->
                        Text(
                            color = colorResource(R.color.white),
                            fontSize = 16.sp,
                            text = film
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PersonDetailScreenPreview() {
    PersonDetailContent(
        uiState = PersonDetailScreenUiState(
            isLoading = false,
            personViewData = PersonViewData(
                name = "Luke Skywalker",
                height = "172",
                mass = "77",
                hairColor = "blond",
                skinColor = "fair",
                eyeColor = "blue",
                birthYear = "19BBY",
                gender = "male",
                homeworld = "Tatooine",
                films = listOf("A New Hope", "The Empire Strikes Back", "Return of the Jedi"),
                species = listOf("Human"),
                vehicles = listOf("Snowspeeder", "Imperial Speeder Bike"),
                starships = listOf("X-wing", "Imperial Shuttle"),
                url = "https://swapi.dev/api/people/1/"
            )
        ),
        showBottomSheet = false,
        onToggleBottomSheet = {},
        onDismissBottomSheet = {}
    )
}
