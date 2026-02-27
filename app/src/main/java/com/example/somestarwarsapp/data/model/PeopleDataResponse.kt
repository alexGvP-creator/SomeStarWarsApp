package com.example.somestarwarsapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PeopleDataResponse(
    @SerialName("count") val count: Int,
    @SerialName("next") val next: String?,
    @SerialName("previous") val previous: String?,
    @SerialName("results") val results: List<Person>
) {
    @Serializable
    data class Person(
        @SerialName("name") val name: String,
        @SerialName("height") val height: String,
        @SerialName("mass") val mass: String,
        @SerialName("hair_color") val hairColor: String? = null,
        @SerialName("skin_color") val skinColor: String? = null,
        @SerialName("eye_color") val eyeColor: String? = null,
        @SerialName("birth_year") val birthYear: String? = null,
        @SerialName("gender") val gender: String? = null,
        @SerialName("homeworld") val homeworld: String? = null,
        @SerialName("films") val films: List<String> = emptyList(),
        @SerialName("species") val species: List<String> = emptyList(),
        @SerialName("vehicles") val vehicles: List<String> = emptyList(),
        @SerialName("starships") val starships: List<String> = emptyList(),
        @SerialName("url") val url: String
    )
}
