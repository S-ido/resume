package com.chebdowski.resume.composition

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.font
import androidx.compose.ui.text.font.fontFamily
import androidx.compose.ui.unit.sp
import com.chebdowski.resume.R

private val LatoFontFamily = fontFamily(
    font(R.font.lato_regular),
    font(R.font.lato_light, FontWeight.Light)
)

private val WorkSansFontFamily = fontFamily(
    font(R.font.worksans_regular),
    font(R.font.worksans_medium, FontWeight.Medium)
)

private val NunitoSansFontFamily = fontFamily(
    font(R.font.nunitosans_regular),
    font(R.font.nunitosans_extrabold, FontWeight.ExtraBold)
)

private val DawningOfANewDayFontFamily = fontFamily(
    font(R.font.dawningofanewday)
)

val ResumeTypography = Typography(
    defaultFontFamily = NunitoSansFontFamily,
    h1 = TextStyle(
        fontFamily = LatoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 58.sp
    ),
    h2 = TextStyle(
        fontFamily = WorkSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = 3.sp
    ),
    h3 = TextStyle(
        fontFamily = WorkSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        letterSpacing = 3.sp
    ),
    h4 = TextStyle(
        fontFamily = NunitoSansFontFamily,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)