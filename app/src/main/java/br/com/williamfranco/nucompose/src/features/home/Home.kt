package br.com.williamfranco.nucompose.src.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
// import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.williamfranco.nucompose.src.theme.NuColor03
import br.com.williamfranco.nucompose.src.theme.NuComposeTheme
import br.com.williamfranco.nucompose.src.widgets.*

@Composable
fun MenuList() {
    Column() {
        ButtonAccount()
        AccountBalance()
        ActionViewList()
        CreditCard()
        Info()
        Divider(color = NuColor03, thickness = 2.dp)
        CreditInfo01()
        Divider(color = NuColor03, thickness = 2.dp)
        CreditInfo02()
        Divider(color = NuColor03, thickness = 2.dp)
        ServiceInfo02()
        Divider(color = NuColor03, thickness = 2.dp)
        DiscoveryInfo()
    }
}

@Composable
fun Home() {
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        scrollState.animateScrollTo(0)
    }

    Column(
        modifier = Modifier
            .background(Color(0xFF223322))
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        HeaderUser()
        MenuList()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NuComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Home()
        }
    }
}
