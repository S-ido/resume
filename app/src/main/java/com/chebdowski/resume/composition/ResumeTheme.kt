package com.chebdowski.resume.composition

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkGrey = Color(0xFF121212)
private val Yellow = Color(0xFFF6E547)
private val Gold = Color(0xFFF3B711)
private val Green = Color(0xFF3DDC84)
private val Navy = Color(0xFF073042)


private val DarkPalette = darkColors(
    primary = Color.White,
    secondary = Yellow,
    background = DarkGrey,
)

private val LightPalette = lightColors(
    primary = DarkGrey,
    secondary = Green,
    background = Color.White
)

@Composable
fun ResumeTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    colors: Colors? = null,
    content: @Composable () -> Unit
) {
    val colorPalette = colors ?: if (isDarkTheme) DarkPalette else LightPalette

    MaterialTheme(
        colors = colorPalette,
        content = content,
        typography = ResumeTypography,
    )
}