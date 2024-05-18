package com.giraffe.countriesapp.domain.usecases

import com.giraffe.countriesapp.domain.repository.Repository
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke() = repository.getCountries()
}