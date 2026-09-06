package br.com.williamfranco.nucompose.src.features.home.models

import androidx.annotation.DrawableRes

data class QuickAction(
    val label: String,
    @DrawableRes val iconRes: Int,
)

data class PromoCard(
    val prefix: String,
    val highlight: String,
    val suffix: String,
)

data class CreditCardInfo(
    val title: String,
    @DrawableRes val iconRes: Int,
)

data class CreditInfo(
    @DrawableRes val iconRes: Int,
    val title: String,
    val subtitle: String,
    val amount: String,
    val footer: String,
)

data class LoanInfo(
    @DrawableRes val iconRes: Int,
    val title: String,
    val description: String,
)

data class InsuranceInfo(
    @DrawableRes val iconRes: Int,
    val title: String,
    val description: String,
)

data class DiscoveryCardItem(
    val title: String,
    val description: String,
    val buttonTitle: String,
)

const val HIDDEN_AMOUNT = "R$ ••••"

data class HomeUiState(
    val userName: String = "",
    val balance: String = "",
    val quickActions: List<QuickAction> = emptyList(),
    val creditCard: CreditCardInfo? = null,
    val promoCards: List<PromoCard> = emptyList(),
    val creditInfo: CreditInfo? = null,
    val loanInfo: LoanInfo? = null,
    val insuranceInfo: InsuranceInfo? = null,
    val discoveryCards: List<DiscoveryCardItem> = emptyList(),
    val isLoading: Boolean = true,
    val isBalanceVisible: Boolean = true,
)
