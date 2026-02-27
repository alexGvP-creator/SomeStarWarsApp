package com.example.somestarwarsapp.di

import com.example.somestarwarsapp.data.remote.StarWarsApiService
import com.example.somestarwarsapp.data.repository.StarWarsApiRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val STAR_WARS_API_BASE_URL = "https://swapi.dev"

private fun provideStarWarsRetrofit(converterFactory: GsonConverterFactory) = Retrofit.Builder()
    .baseUrl(STAR_WARS_API_BASE_URL)
    .addConverterFactory(converterFactory)
    .build()


private fun provideGsonConverterFactory() = GsonConverterFactory.create()

private fun providerStarWarsApiService(retrofit: Retrofit) =
    retrofit.create(StarWarsApiService::class.java)

private fun provideStarWarsApiRepository(starWarsApiService: StarWarsApiService) =
    StarWarsApiRepositoryImpl(starWarsApiService)


val networkModule = module {

    single { ::provideStarWarsRetrofit }
    single { ::provideGsonConverterFactory }
    single { ::providerStarWarsApiService }
    single { ::provideStarWarsApiRepository }
}