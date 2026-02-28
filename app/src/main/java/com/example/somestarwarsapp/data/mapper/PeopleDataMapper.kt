package com.example.somestarwarsapp.data.mapper

import com.example.somestarwarsapp.data.model.PeopleDataResponse
import com.example.somestarwarsapp.domain.model.PeopleData

class PeopleDataMapper() {

    fun mapPersonData(response: PeopleDataResponse.Person): PeopleData.Person {
        return PeopleData.Person(
            name = response.name,
            height = response.height,
            mass = response.mass,
            hairColor = response.hairColor,
            skinColor = response.skinColor,
            eyeColor = response.eyeColor,
            birthYear = response.birthYear,
            gender = response.gender,
            homeworld = response.homeworld,
            films = response.films,
            species = response.species,
            vehicles = response.vehicles,
            starships = response.starships,
            url = response.url
        )
    }


    fun mapPeopleData(response: PeopleDataResponse): PeopleData {
        return PeopleData(
            count = response.count,
            next = response.next,
            previous = response.previous,
            results = response.results.map {
                mapPersonData(it)
            }
        )
    }
}