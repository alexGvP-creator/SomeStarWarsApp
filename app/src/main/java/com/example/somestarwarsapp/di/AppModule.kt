package com.example.somestarwarsapp.di

import com.example.somestarwarsapp.ui.mapper.PeopleViewDataMapper
import com.example.somestarwarsapp.ui.navigation.Navigator
import com.example.somestarwarsapp.ui.navigation.Route
import com.example.somestarwarsapp.ui.screen.home.HomeScreen
import com.example.somestarwarsapp.viewmodel.HomeScreenViewModel
import org.koin.androidx.scope.dsl.activityRetainedScope
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.navigation3.navigation


@OptIn(KoinExperimentalAPI::class)
val appModule = module {

    viewModel {
        HomeScreenViewModel(
            repository = get(),
            peopleViewDataMapper = get()
        )
    }

    activityRetainedScope {

        scoped { Navigator(startDestination = Route.HomeRoute) }

        navigation<Route.HomeRoute> {
            HomeScreen(
                viewModel = koinViewModel(),
                navigator = get()
            )
        }
    }

    single { PeopleViewDataMapper() }
}
