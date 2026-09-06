package br.com.williamfranco.nucompose.src.features.home.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.williamfranco.nucompose.src.features.home.view_models.HomeViewModel
import br.com.williamfranco.nucompose.src.features.home.view_models.HomeViewModelImpl
import br.com.williamfranco.nucompose.src.features.home.views.HomeView
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoute() {
    val viewModel: HomeViewModel = koinViewModel<HomeViewModelImpl>()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeView(
        uiState = uiState,
        onQuickActionClick = viewModel::onQuickActionClick,
        onToggleBalanceVisibility = viewModel::onToggleBalanceVisibility,
    )
}
