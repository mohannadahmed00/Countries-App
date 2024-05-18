package com.giraffe.countriesapp.data.datasource.remote

import com.giraffe.CountriesQuery
import com.giraffe.CountryQuery
import com.giraffe.countriesapp.data.datasource.remote.responses.DetailedCountryResponse
import com.giraffe.countriesapp.data.datasource.remote.responses.SimpleCountryResponse
import com.giraffe.countriesapp.domain.entities.DetailedCountryEntity
import com.giraffe.countriesapp.domain.entities.SimpleCountryEntity

fun CountriesQuery.Country.toSimpleCountryResponse() = SimpleCountryResponse(
    name = name,
    code = code,
    emoji = emoji,
    capital = capital
)

fun CountryQuery.Country.toDetailedCountryResponse() = DetailedCountryResponse(
    name = name,
    code = code,
    emoji = emoji,
    capital = capital,
    currency = currency,
    continent = continent.name,
    languages = languages.map { it.name }
)

fun SimpleCountryResponse.toSimpleCountryEntity() = SimpleCountryEntity(
    name = name,
    code = code,
    emoji = emoji,
    capital = capital
)

fun DetailedCountryResponse.toDetailedCountryEntity() = DetailedCountryEntity(
    name = name,
    code = code,
    emoji = emoji,
    capital = capital,
    currency = currency,
    continent = continent,
    languages = languages
)