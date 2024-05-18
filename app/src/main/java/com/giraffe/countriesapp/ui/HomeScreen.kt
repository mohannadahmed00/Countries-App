package com.giraffe.countriesapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.giraffe.countriesapp.domain.entities.DetailedCountryEntity
import com.giraffe.countriesapp.domain.entities.SimpleCountryEntity

@Composable
fun HomeScreen(
    mViewModel: HomeViewModel = hiltViewModel()
) {
    val state by mViewModel.state.collectAsState()
    HomeContent(state, mViewModel::selectCountry, mViewModel::onDismiss)
}

@Composable
fun HomeContent(
    state: HomeState,
    onSelect: (String) -> Unit,
    onDismiss: () -> Unit
) {
    Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        if (state.isLoading) {
            CircularProgressIndicator(color = Color.LightGray)
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.countries) {
                SimpleCountryItem(it, onSelect)
            }
        }
        if (state.selectedCountry != null) {
            DetailedCountryDialog(state.selectedCountry, onDismiss)
        }
    }

}

@Composable
fun SimpleCountryItem(simpleCountry: SimpleCountryEntity, onSelect: (code: String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(simpleCountry.code) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = simpleCountry.emoji)
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = simpleCountry.name)
            Text(text = simpleCountry.capital ?: "", style = TextStyle(color = Color.LightGray))
        }
    }
}

@Composable
fun DetailedCountryDialog(detailedCountry: DetailedCountryEntity, onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Card(
            colors = CardDefaults.cardColors().copy(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = detailedCountry.emoji
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        modifier = Modifier.weight(1f),
                        text = detailedCountry.name
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "(${detailedCountry.capital ?: "no capital"})",
                        style = TextStyle(color = Color.LightGray)
                    )

                }
                Text(
                    text = "Continent: ${detailedCountry.continent}",
                    style = TextStyle(color = Color.LightGray)
                )
                Text(
                    text = "Currency: ${detailedCountry.currency ?: ""}",
                    style = TextStyle(color = Color.LightGray)
                )
                Text(
                    text = "Languages: ${detailedCountry.languages.joinToString()}",
                    style = TextStyle(color = Color.LightGray)
                )
            }
        }

    }

}