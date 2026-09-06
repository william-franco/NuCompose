package br.com.williamfranco.nucompose.src.features.home.repositories

import br.com.williamfranco.nucompose.R
import br.com.williamfranco.nucompose.src.features.home.models.CreditCardInfo
import br.com.williamfranco.nucompose.src.features.home.models.CreditInfo
import br.com.williamfranco.nucompose.src.features.home.models.DiscoveryCardItem
import br.com.williamfranco.nucompose.src.features.home.models.HomeUiState
import br.com.williamfranco.nucompose.src.features.home.models.InsuranceInfo
import br.com.williamfranco.nucompose.src.features.home.models.LoanInfo
import br.com.williamfranco.nucompose.src.features.home.models.PromoCard
import br.com.williamfranco.nucompose.src.features.home.models.QuickAction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface HomeRepository {
    fun observeHome(): Flow<HomeUiState>
}

class HomeRepositoryImpl : HomeRepository {

    override fun observeHome(): Flow<HomeUiState> = flow {
        emit(buildHomeState())
    }

    private fun buildHomeState(): HomeUiState = HomeUiState(
        userName = "William Franco",
        balance = "R$ 741,00",
        quickActions = listOf(
            QuickAction("Área Pix", R.drawable.ic_qrcode),
            QuickAction("Pagar", R.drawable.ic_barcode),
            QuickAction("Guardar dinheiro", R.drawable.ic_piggy_bank_outline),
            QuickAction("Recarga de celular", R.drawable.ic_cellphone),
            QuickAction("Transferir", R.drawable.ic_cash),
            QuickAction("Depositar", R.drawable.ic_cash),
            QuickAction("Pegar emprestado", R.drawable.ic_hand_heart),
            QuickAction("Doações", R.drawable.ic_heart_outline),
            QuickAction("Pedir Extrato", R.drawable.ic_file_outline),
            QuickAction("Transferir Internac.", R.drawable.ic_web),
            QuickAction("Encontrar atalhos", R.drawable.ic_help_circle_outline),
        ),
        creditCard = CreditCardInfo(
            title = "Meus cartões",
            iconRes = R.drawable.ic_credit_card_outline,
        ),
        promoCards = listOf(
            PromoCard(
                prefix = "Você tem ",
                highlight = "R$ 16.700,00",
                suffix = " disponível para empréstimo",
            ),
            PromoCard(
                prefix = "Salve seus amigos da burocracia.",
                highlight = " Faça um convite para o NuBank",
                suffix = "",
            ),
        ),
        creditInfo = CreditInfo(
            iconRes = R.drawable.ic_credit_card_outline,
            title = "Cartão de crédito",
            subtitle = "Fatura atual",
            amount = "R$ 155,00",
            footer = "Limite disponível de R$ 4600,00",
        ),
        loanInfo = LoanInfo(
            iconRes = R.drawable.ic_bank,
            title = "Empréstimo",
            description = "Valor dispínvel de até\nR$ 16.700,00",
        ),
        insuranceInfo = InsuranceInfo(
            iconRes = R.drawable.ic_heart_outline,
            title = "Seguro de vida",
            description = "Conheça NuBank Vida: um seguro simples e que cabe no bolso",
        ),
        discoveryCards = listOf(
            DiscoveryCardItem(
                title = "Indique seus amigos",
                description = "Mosque aos seus amigos como é fácil ter uma vida sem burocracia",
                buttonTitle = "Indicar amigos",
            ),
            DiscoveryCardItem(
                title = "Whastapp",
                description = "Pagamentos seguros, rápido e sem tarifa. A experiência NuBank se, nem sair da conversa",
                buttonTitle = "Quero conhecer",
            ),
            DiscoveryCardItem(
                title = "Débido Automático",
                description = "Suas contas no débito automático e você com tempo para curtir a vida, sem pagar juros por atraso",
                buttonTitle = "Saiba mais",
            ),
        ),
        isLoading = false,
    )
}
