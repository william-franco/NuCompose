package br.com.williamfranco.nucompose.src.features.home.view_models

import br.com.williamfranco.nucompose.R
import br.com.williamfranco.nucompose.src.features.home.models.HomeUiState
import br.com.williamfranco.nucompose.src.features.home.models.QuickAction
import br.com.williamfranco.nucompose.src.fakes.FakeHomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `emits home state from repository`() = runTest {
        val expectedState = HomeUiState(
            userName = "William Franco",
            balance = "R$ 741,00",
            quickActions = listOf(
                QuickAction("Área Pix", R.drawable.ic_qrcode),
                QuickAction("Pagar", R.drawable.ic_barcode),
            ),
            isLoading = false,
        )
        val viewModel = HomeViewModelImpl(FakeHomeRepository(expectedState))

        advanceUntilIdle()

        val state = viewModel.uiState.value
        assertEquals("William Franco", state.userName)
        assertEquals("R$ 741,00", state.balance)
        assertEquals(2, state.quickActions.size)
        assertFalse(state.isLoading)
    }

    @Test
    fun `toggle balance visibility flips isBalanceVisible`() = runTest {
        val expectedState = HomeUiState(
            userName = "William Franco",
            balance = "R$ 741,00",
            isLoading = false,
            isBalanceVisible = true,
        )
        val viewModel = HomeViewModelImpl(FakeHomeRepository(expectedState))

        advanceUntilIdle()
        assertEquals(true, viewModel.uiState.value.isBalanceVisible)
        assertEquals("R$ 741,00", viewModel.uiState.value.balance)

        viewModel.onToggleBalanceVisibility()
        assertEquals(false, viewModel.uiState.value.isBalanceVisible)
        assertEquals("William Franco", viewModel.uiState.value.userName)
        assertEquals("R$ 741,00", viewModel.uiState.value.balance)

        viewModel.onToggleBalanceVisibility()
        assertEquals(true, viewModel.uiState.value.isBalanceVisible)
    }
}
