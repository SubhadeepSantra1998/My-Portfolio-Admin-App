package com.example.myportfolioadminapp.common.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myportfolioadminapp.R

// Set of Material typography styles to start with
private val quickSand = FontFamily(
    Font(R.font.quicksand_light, weight = FontWeight.Light),
    Font(R.font.quicksand_regular, weight = FontWeight.Normal),
    Font(R.font.quicksand_medium, weight = FontWeight.Medium),
    Font(R.font.quicksand_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.quicksand_bold, weight = FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = quickSand,
        fontSize = 34.sp,
        fontWeight = FontWeight.ExtraBold,
    ),
    displayMedium = TextStyle(
        fontFamily = quickSand,
        fontSize = 32.sp,
        fontWeight = FontWeight.ExtraBold,
    ),
    displaySmall = TextStyle(
        fontFamily = quickSand,
        fontSize = 28.sp,
        fontWeight = FontWeight.ExtraBold,
    ),
    headlineLarge = TextStyle(
        fontFamily = quickSand,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
    ),
    headlineMedium = TextStyle(
        fontFamily = quickSand,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
    ),
    headlineSmall = TextStyle(
        fontFamily = quickSand,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
    ),
    titleLarge = TextStyle(
        fontFamily = quickSand,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    titleMedium = TextStyle(
        fontFamily = quickSand,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    titleSmall = TextStyle(
        fontFamily = quickSand,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold,
    ),
    bodyLarge = TextStyle(
        fontFamily = quickSand,
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
    ),
    bodyMedium = TextStyle(
        fontFamily = quickSand,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
    ),
    bodySmall = TextStyle(
        fontFamily = quickSand,
        fontSize = 13.sp,
        fontWeight = FontWeight.Medium
    ),
    labelLarge = TextStyle(
        fontFamily = quickSand,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
    ),
    labelMedium = TextStyle(
        fontFamily = quickSand,
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
    ),
    labelSmall = TextStyle(
        fontFamily = quickSand,
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
    )
)