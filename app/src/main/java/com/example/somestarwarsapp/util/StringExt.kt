package com.example.somestarwarsapp.util

fun String?.orDefault(default: String): String {
    return this ?: default
}
