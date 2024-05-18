package com.giraffe.countriesapp.domain.usecases

import com.giraffe.countriesapp.domain.repository.Repository
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(code: String) = repository.getCountry(code = code)
}