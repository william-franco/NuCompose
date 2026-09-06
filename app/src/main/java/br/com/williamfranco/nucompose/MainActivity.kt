package br.com.williamfranco.nucompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.williamfranco.nucompose.src.design.theme.NuComposeTheme
import br.com.williamfranco.nucompose.src.routes.RoutesApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NuComposeTheme {
                RoutesApp()
            }
        }
    }
}
