package com.example.somestarwarsapp.domain.repository

import com.example.somestarwarsapp.domain.model.ApiResult

interface StarWarsApiRepository {

    suspend fun fetchPeople(page: Int): ApiResult

    suspend fun fetchPerson(id: Int): ApiResult
}
