package br.com.williamfranco.nucompose.src.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.williamfranco.nucompose.src.features.home.routes.HomeRoute

@Composable
fun RoutesApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
    ) {
        composable(Routes.HOME) {
            HomeRoute()
        }
    }
}
