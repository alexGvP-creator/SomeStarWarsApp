package com.example.somestarwarsapp.ui.mapper

import com.example.somestarwarsapp.domain.model.PeopleData
import com.example.somestarwarsapp.ui.model.PeopleViewData
import com.example.somestarwarsapp.ui.model.PersonViewData

class PeopleViewDataMapper() {

    fun mapPersonViewData(personData: PeopleData.Person): PersonViewData {
        return PersonViewData(
            name = personData.name,
            height = personData.height,
            mass = personData.mass,
            hairColor = personData.hairColor,
            skinColor = personData.skinColor,
            eyeColor = personData.eyeColor,
            birthYear = personData.birthYear,
            gender = personData.gender,
            homeworld = personData.homeworld,
            films = personData.films,
            species = personData.species,
            vehicles = personData.vehicles,
            starships = personData.starships,
            id = personData.id
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