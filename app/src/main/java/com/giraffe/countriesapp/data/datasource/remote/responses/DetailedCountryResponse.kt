package com.giraffe.countriesapp.data.datasource.remote.responses

data class DetailedCountryResponse(
    val name: String,
    val capital: String?,
    val code: String,
    val emoji: String,
    val currency: String?,
    val languages: List<String>,
    val continent: String,
)
