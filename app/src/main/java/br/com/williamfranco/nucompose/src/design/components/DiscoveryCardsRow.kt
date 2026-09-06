package br.com.williamfranco.nucompose.src.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.williamfranco.nucompose.src.features.home.models.DiscoveryCardItem

@Composable
fun DiscoveryCardsRow(discoveryCards: List<DiscoveryCardItem>) {
    val scrollState = rememberScrollState()
    LaunchedEffect(Unit) {
        scrollState.animateScrollTo(0)
    }

    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(vertical = 10.dp)
            .horizontalScroll(scrollState)
            .padding(bottom = 10.dp),
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        discoveryCards.forEach { card ->
            DiscoveryCard(card = card)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}
