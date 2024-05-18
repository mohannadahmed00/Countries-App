package com.giraffe.countriesapp.domain.repository

import com.giraffe.countriesapp.domain.entities.DetailedCountryEntity
import com.giraffe.countriesapp.domain.entities.SimpleCountryEntity

interface Repository {
    suspend fun getCountries(): List<SimpleCountryEntity>
    suspend fun getCountry(code: String): DetailedCountryEntity?
}