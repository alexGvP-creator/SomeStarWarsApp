package com.example.somestarwarsapp.di

import com.example.somestarwarsapp.data.mapper.PeopleDataMapper
import com.example.somestarwarsapp.data.remote.StarWarsApiService
import com.example.somestarwarsapp.data.repository.StarWarsApiRepositoryImpl
import com.example.somestarwarsapp.domain.repository.StarWarsApiRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

private const val STAR_WARS_API_BASE_URL = "https://swapi.dev"

private fun provideStarWarsRetrofit(converterFactory: Converter.Factory) = Retrofit.Builder()
    .baseUrl(STAR_WARS_API_BASE_URL)
    .addConverterFactory(converterFactory)
    .build()


private fun provideJsonConverterFactory(): Converter.Factory {
    val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
    val contentType = "application/json".toMediaType()
    return json.asConverterFactory(contentType)
}

private fun provideStarWarsApiService(retrofit: Retrofit) =
    retrofit.create(StarWarsApiService::class.java)


private fun providePeopleDataMapper() = PeopleDataMapper()

private fun provideStarWarsApiRepository(
    starWarsApiService: StarWarsApiService,
    peopleDataMapper: PeopleDataMapper
): StarWarsApiRepository {
    return StarWarsApiRepositoryImpl(starWarsApiService, peopleDataMapper)
}

val networkModule = module {


    single { provideStarWarsRetrofit(get()) }
    single { provideJsonConverterFactory() }
    single { provideStarWarsApiService(get()) }

    single { providePeopleDataMapper() }

    single {
        provideStarWarsApiRepository(
            get(),
            get()
        )
    }
}