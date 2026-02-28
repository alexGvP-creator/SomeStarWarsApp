package com.example.somestarwarsapp.data.remote

import com.example.somestarwarsapp.data.model.PeopleDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StarWarsApiService {

    @GET("/api/people/")
    suspend fun getPeople(@Query("page") page: Int): Response<PeopleDataResponse>
}