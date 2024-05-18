package com.giraffe.countriesapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giraffe.countriesapp.domain.usecases.GetCountriesUseCase
import com.giraffe.countriesapp.domain.usecases.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            _state.update { it.copy(countries = getCountriesUseCase(), isLoading = false) }
        }
    }

    fun selectCountry(code: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            _state.update { it.copy(selectedCountry = getCountryUseCase(code), isLoading = false) }
        }
    }

    fun onDismiss() {
        viewModelScope.launch {
            _state.update { it.copy(selectedCountry = null) }
        }
    }
}