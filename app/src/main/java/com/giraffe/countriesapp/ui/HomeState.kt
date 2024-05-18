package com.giraffe.countriesapp.ui

import com.giraffe.countriesapp.domain.entities.DetailedCountryEntity
import com.giraffe.countriesapp.domain.entities.SimpleCountryEntity

data class HomeState(
    val isLoading: Boolean = false,
    val countries: List<SimpleCountryEntity> = emptyList(),
    val selectedCountry: DetailedCountryEntity? = null
)
