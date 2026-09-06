package br.com.williamfranco.nucompose.src.features.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.williamfranco.nucompose.src.design.components.AccountBalance
import br.com.williamfranco.nucompose.src.design.components.ActionViewList
import br.com.williamfranco.nucompose.src.design.components.ButtonAccount
import br.com.williamfranco.nucompose.src.design.components.CreditCardSection
import br.com.williamfranco.nucompose.src.design.components.CreditInfoSection
import br.com.williamfranco.nucompose.src.design.components.DiscoveryCardsRow
import br.com.williamfranco.nucompose.src.design.components.HeaderUser
import br.com.williamfranco.nucompose.src.design.components.InsuranceInfoSection
import br.com.williamfranco.nucompose.src.design.components.LoanInfoSection
import br.com.williamfranco.nucompose.src.design.components.PromoCardsRow
import br.com.williamfranco.nucompose.src.design.theme.NuColor03
import br.com.williamfranco.nucompose.src.design.theme.NuComposeTheme
import br.com.williamfranco.nucompose.src.features.home.models.HomeUiState

@Composable
fun HomeView(
    uiState: HomeUiState,
    onQuickActionClick: (String) -> Unit = {},
    onToggleBalanceVisibility: () -> Unit = {},
) {
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        scrollState.animateScrollTo(0)
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .navigationBarsPadding()
            .verticalScroll(scrollState),
    ) {
        HeaderUser(
            userName = uiState.userName,
            isBalanceVisible = uiState.isBalanceVisible,
            onToggleBalanceVisibility = onToggleBalanceVisibility,
        )
        HomeMenuList(
            uiState = uiState,
            onQuickActionClick = onQuickActionClick,
        )
    }
}

@Composable
private fun HomeMenuList(
    uiState: HomeUiState,
    onQuickActionClick: (String) -> Unit,
) {
    Column {
        ButtonAccount()
        AccountBalance(
            balance = uiState.balance,
            isVisible = uiState.isBalanceVisible,
        )
        ActionViewList(
            quickActions = uiState.quickActions,
            onQuickActionClick = onQuickActionClick,
        )
        uiState.creditCard?.let { CreditCardSection(creditCard = it) }
        PromoCardsRow(promoCards = uiState.promoCards)
        HorizontalDivider(color = NuColor03, thickness = 2.dp)
        uiState.creditInfo?.let {
            CreditInfoSection(
                creditInfo = it,
                isBalanceVisible = uiState.isBalanceVisible,
            )
        }
        HorizontalDivider(color = NuColor03, thickness = 2.dp)
        uiState.loanInfo?.let { LoanInfoSection(loanInfo = it) }
        HorizontalDivider(color = NuColor03, thickness = 2.dp)
        uiState.insuranceInfo?.let { InsuranceInfoSection(insuranceInfo = it) }
        HorizontalDivider(color = NuColor03, thickness = 2.dp)
        DiscoveryCardsRow(discoveryCards = uiState.discoveryCards)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeViewPreview() {
    NuComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
        ) {
            HomeView(uiState = HomeUiState(userName = "William Franco", balance = "R$ 741,00"))
        }
    }
}
