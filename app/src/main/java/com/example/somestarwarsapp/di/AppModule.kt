package com.example.somestarwarsapp.di

import com.example.somestarwarsapp.ui.mapper.PeopleViewDataMapper
import com.example.somestarwarsapp.ui.navigation.Navigator
import com.example.somestarwarsapp.ui.navigation.Route
import com.example.somestarwarsapp.ui.screen.home.HomeScreen
import com.example.somestarwarsapp.ui.screen.persondetail.PersonDetailScreen
import com.example.somestarwarsapp.viewmodel.HomeScreenViewModel
import com.example.somestarwarsapp.viewmodel.PersonDetailScreenViewModel
import org.koin.androidx.scope.dsl.activityRetainedScope
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.module.dsl.viewModel
import org.koin.core.parameter.parametersOf
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

    viewModel {
        PersonDetailScreenViewModel(get())
    }

    single { PeopleViewDataMapper() }

    activityRetainedScope {
        scoped { Navigator(startDestination = Route.HomeRoute) }

        navigation<Route.HomeRoute> {
            val navigator = get<Navigator>()

            HomeScreen(
                viewModel = koinViewModel(),
                onPersonDetailClick = { detail ->
                    navigator.goTo(Route.PersonDetailRoute(detail))
                }
            )
        }

        navigation<Route.PersonDetailRoute> { route ->

            PersonDetailScreen(
                viewModel = koinViewModel { parametersOf(route.personViewData) }
            )
        }
    }
}
