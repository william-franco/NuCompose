package br.com.williamfranco.nucompose.src.features.home.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.williamfranco.nucompose.src.features.home.models.HomeUiState
import br.com.williamfranco.nucompose.src.features.home.repositories.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

interface HomeViewModel {
    val uiState: StateFlow<HomeUiState>

    fun onQuickActionClick(label: String)
    fun onToggleBalanceVisibility()
}

class HomeViewModelImpl(
    private val homeRepository: HomeRepository,
) : ViewModel(), HomeViewModel {

    private val _uiState = MutableStateFlow(HomeUiState())
    override val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        observeHome()
    }

    private fun observeHome() {
        homeRepository.observeHome()
            .onEach { fromRepo ->
                _uiState.update { current ->
                    fromRepo.copy(isBalanceVisible = current.isBalanceVisible)
                }
            }
            .launchIn(viewModelScope)
    }

    override fun onQuickActionClick(label: String) = Unit

    override fun onToggleBalanceVisibility() {
        _uiState.update { it.copy(isBalanceVisible = !it.isBalanceVisible) }
    }
}
