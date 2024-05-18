package com.giraffe.countriesapp.data.datasource.remote.responses


data class SimpleCountryResponse(
    val name: String,
    val capital: String?,
    val code: String,
    val emoji: String,
)
