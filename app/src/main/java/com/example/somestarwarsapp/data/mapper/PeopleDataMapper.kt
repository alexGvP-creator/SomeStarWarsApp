package com.example.somestarwarsapp.data.mapper

import android.util.Log
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
            id = response.url.extractId()
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

    private fun String.extractId(): Int {
        val urlParts = split(URL_FIRST_PART)
        try {
            return urlParts.getOrNull(1)
                ?.replace(URL_LAST_PART, "")
                ?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            Log.e("ExtractId:", "extracting id failed: $e")
            return 0
        }
    }

    companion object {
        private const val URL_FIRST_PART = "https://swapi.dev/api/people/"
        private const val URL_LAST_PART = "/"
    }
}