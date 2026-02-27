package com.example.somestarwarsapp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

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
        @SerialName("hair_color") val hairColor: String,
        @SerialName("skin_color") val skinColor: String,
        @SerialName("eye_color") val eyeColor: String,
        @SerialName("birth_year") val birthYear: String,
        @SerialName("gender") val gender: String,
        @SerialName("homeworld") val homeworld: String? = null,
        @SerialName("films") val films: List<String> = emptyList(),
        @SerialName("species") val species: List<String> = emptyList(),
        @SerialName("vehicles") val vehicles: List<String> = emptyList(),
        @SerialName("starships") val starships: List<String> = emptyList(),
        @SerialName("created") val created: Instant,
        @SerialName("edited") val edited: Instant,
        @SerialName("url") val url: String
    )
}
