package com.giraffe.countriesapp.data.datasource.remote

import com.apollographql.apollo3.ApolloClient
import com.giraffe.CountriesQuery
import com.giraffe.CountryQuery

class RemoteDataSourceImp(private val apolloClient: ApolloClient) : RemoteDataSource {
    override suspend fun getCountries() = apolloClient
        .query(CountriesQuery())
        .execute()
        .data
        ?.countries?.map { it.toSimpleCountryResponse() } ?: emptyList()

    override suspend fun getCountry(code: String) = apolloClient
        .query(CountryQuery(code))
        .execute()
        .data?.country?.toDetailedCountryResponse()
}