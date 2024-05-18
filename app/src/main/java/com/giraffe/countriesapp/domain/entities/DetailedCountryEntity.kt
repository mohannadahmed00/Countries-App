package com.giraffe.countriesapp.domain.entities

data class DetailedCountryEntity(
    val name: String,
    val capital: String?,
    val code: String,
    val emoji: String,
    val currency: String?,
    val languages: List<String>,
    val continent: String,
)
