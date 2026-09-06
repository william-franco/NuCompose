package br.com.williamfranco.nucompose.src.fakes

import br.com.williamfranco.nucompose.src.features.home.models.HomeUiState
import br.com.williamfranco.nucompose.src.features.home.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeHomeRepository(
    private val homeState: HomeUiState = HomeUiState(
        userName = "William Franco",
        balance = "R$ 741,00",
        isLoading = false,
    ),
) : HomeRepository {

    override fun observeHome(): Flow<HomeUiState> = flowOf(homeState)
}
