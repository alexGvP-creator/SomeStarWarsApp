package com.example.somestarwarsapp.data.repository

import com.example.somestarwarsapp.data.model.PeopleDataResponse
import com.example.somestarwarsapp.data.remote.StarWarsApiService
import com.example.somestarwarsapp.domain.model.ApiResult
import com.example.somestarwarsapp.domain.model.PeopleData
import com.example.somestarwarsapp.domain.model.PersonData
import com.example.somestarwarsapp.domain.repository.StarWarsApiRepository
import java.io.IOException

class StarWarsApiRepositoryImpl(private val starWarsApiService: StarWarsApiService) :
    StarWarsApiRepository {

    override suspend fun fetchPeople(page: Int): ApiResult = try {
        val response = starWarsApiService.getPeople(page)

        if (response.isSuccessful) {
            val body = response.body() ?: return ApiResult.OtherError(UNKNOWN_ERROR_MESSAGE)
            ApiResult.Success(body.toPeopleData())
        } else {
            ApiResult.OtherError(UNKNOWN_ERROR_MESSAGE)
        }
    } catch (e: IOException) {
        ApiResult.NetworkError
    } catch (e: Exception) {
        ApiResult.OtherError(e.message ?: UNKNOWN_ERROR_MESSAGE)
    }

    override suspend fun fetchPerson(id: Int): ApiResult = try {
        val response = starWarsApiService.getPerson(id)

        if (response.isSuccessful) {
            val body = response.body() ?: return ApiResult.OtherError(UNKNOWN_ERROR_MESSAGE)
            ApiResult.Success(body.toPersonData())
        } else {
            ApiResult.OtherError(UNKNOWN_ERROR_MESSAGE)
        }
    } catch (e: IOException) {
        ApiResult.NetworkError
    } catch (e: Exception) {
        ApiResult.OtherError(e.message ?: UNKNOWN_ERROR_MESSAGE)
    }


    private fun PeopleDataResponse.Person.toPersonData(): PersonData {
        return PersonData(0)
    }


    private fun PeopleDataResponse.toPeopleData(): PeopleData {
        return PeopleData("")
    }

    companion object {

        private const val UNKNOWN_ERROR_MESSAGE = "Something went wrong."
    }
}