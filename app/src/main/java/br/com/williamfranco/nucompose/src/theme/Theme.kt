package br.com.williamfranco.nucompose.src.theme

import androidx.compose.foundation.isSystemInDarkTheme
// import androidx.compose.material.MaterialTheme
// import androidx.compose.material.darkColors
// import androidx.compose.material.lightColors
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = NuColor01,
    onPrimary = Purple700,
    secondary = NuColor02
)

private val LightColorPalette = lightColorScheme(
    primary = NuColor01,
    onPrimary = Purple700,
    secondary = NuColor02

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun NuComposeTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}