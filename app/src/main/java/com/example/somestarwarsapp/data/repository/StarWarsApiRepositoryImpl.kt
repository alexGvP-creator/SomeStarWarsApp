package com.example.somestarwarsapp.data.repository

import com.example.somestarwarsapp.data.mapper.PeopleDataMapper
import com.example.somestarwarsapp.data.remote.StarWarsApiService
import com.example.somestarwarsapp.domain.model.ApiResult
import com.example.somestarwarsapp.domain.repository.StarWarsApiRepository
import java.io.IOException

class StarWarsApiRepositoryImpl(
    private val starWarsApiService: StarWarsApiService,
    private val peopleDataMapper: PeopleDataMapper
) :
    StarWarsApiRepository {

    override suspend fun fetchPeople(page: Int): ApiResult = try {
        val response = starWarsApiService.getPeople(page)

        if (response.isSuccessful) {
            val body = response.body() ?: return ApiResult.OtherError(UNKNOWN_ERROR_MESSAGE)
            ApiResult.Success(peopleDataMapper.mapPeopleData(body))
        } else {
            ApiResult.OtherError(UNKNOWN_ERROR_MESSAGE)
        }
    } catch (e: IOException) {
        ApiResult.NetworkError
    } catch (e: Exception) {
        ApiResult.OtherError(e.message ?: UNKNOWN_ERROR_MESSAGE)
    }

    companion object {

        private const val UNKNOWN_ERROR_MESSAGE = "Something went wrong."
    }
}