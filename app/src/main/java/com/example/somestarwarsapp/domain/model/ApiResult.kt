package com.example.somestarwarsapp.domain.model

sealed class ApiResult {

    data class Success(val data: Any): ApiResult() // TODO use specific type instead of any

    data class OtherError(val exceptionMessage: String): ApiResult()

    data object NetworkError: ApiResult()
}