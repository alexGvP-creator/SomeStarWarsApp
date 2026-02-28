package com.example.somestarwarsapp.ui.mapper

import com.example.somestarwarsapp.domain.model.PeopleData
import com.example.somestarwarsapp.ui.model.PeopleViewData
import com.example.somestarwarsapp.ui.model.PersonViewData
import com.example.somestarwarsapp.util.orDefault

class PeopleViewDataMapper() {

    private fun mapPersonViewData(personData: PeopleData.Person): PersonViewData {
        return PersonViewData(
            name = personData.name,
            height = personData.height + " cm",
            mass = personData.mass + " kg",
            hairColor = personData.hairColor.orDefault("n/a"),
            skinColor = personData.skinColor.orDefault("n/a"),
            eyeColor = personData.eyeColor.orDefault("n/a"),
            birthYear = personData.birthYear.orDefault("n/a"),
            gender = personData.gender.orDefault("n/a"),
            homeworld = personData.homeworld.orDefault("n/a"),
            films = personData.films,
            species = personData.species,
            vehicles = personData.vehicles,
            starships = personData.starships,
            url = personData.url
        )
    }

    fun mapPeopleViewData(response: PeopleData): PeopleViewData {
        return PeopleViewData(
            next = response.next,
            previous = response.previous,
            results = response.results.map {
                mapPersonViewData(it)
            }
        )
    }
}