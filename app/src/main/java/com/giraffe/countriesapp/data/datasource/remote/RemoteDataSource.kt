package com.giraffe.countriesapp.data.datasource.remote

import com.giraffe.countriesapp.data.datasource.remote.responses.DetailedCountryResponse
import com.giraffe.countriesapp.data.datasource.remote.responses.SimpleCountryResponse

interface RemoteDataSource {
    suspend fun getCountries(): List<SimpleCountryResponse>
    suspend fun getCountry(code: String): DetailedCountryResponse?
}