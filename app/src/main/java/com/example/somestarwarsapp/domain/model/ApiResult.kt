package com.example.somestarwarsapp.domain.model

sealed class ApiResult {

    data class Success(val data: Any) : ApiResult()

    data class OtherError(val exceptionMessage: String) : ApiResult()

    data object NetworkError : ApiResult()
}