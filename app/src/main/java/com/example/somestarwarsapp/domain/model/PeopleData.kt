package com.example.somestarwarsapp.domain.model


data class PeopleData(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Person>
) {
    data class Person(
        val name: String,
        val height: String,
        val mass: String,
        val hairColor: String?,
        val skinColor: String?,
        val eyeColor: String?,
        val birthYear: String?,
        val gender: String?,
        val homeworld: String?,
        val films: List<String>,
        val species: List<String>,
        val vehicles: List<String>,
        val starships: List<String>,
        val url: String
    )
}