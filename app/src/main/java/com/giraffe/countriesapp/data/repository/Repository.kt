package com.giraffe.countriesapp.data.repository

import com.giraffe.countriesapp.data.datasource.remote.RemoteDataSource
import com.giraffe.countriesapp.data.datasource.remote.toDetailedCountryEntity
import com.giraffe.countriesapp.data.datasource.remote.toSimpleCountryEntity
import com.giraffe.countriesapp.domain.repository.Repository

class RepositoryImp(private val remoteDataSource: RemoteDataSource) :
    Repository {
    override suspend fun getCountries() =
        remoteDataSource.getCountries().map { it.toSimpleCountryEntity() }

    override suspend fun getCountry(code: String) =
        remoteDataSource.getCountry(code)?.toDetailedCountryEntity()
}