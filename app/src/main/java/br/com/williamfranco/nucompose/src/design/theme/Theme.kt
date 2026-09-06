package br.com.williamfranco.nucompose.src.design.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val NuLightColorPalette = lightColorScheme(
    primary = NuColor01,
    onPrimary = white,
    secondary = NuColor02,
    onSecondary = white,
    background = white,
    surface = white,
    onBackground = Color(0xFF000000),
    onSurface = Color(0xFF000000),
)

@Composable
fun NuComposeTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NuLightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}
