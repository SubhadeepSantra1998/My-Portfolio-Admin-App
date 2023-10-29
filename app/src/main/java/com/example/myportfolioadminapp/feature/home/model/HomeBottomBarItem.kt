package com.example.myportfolioadminapp.feature.home.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.School
import androidx.compose.ui.graphics.vector.ImageVector


sealed class HomeBottomBarItem(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
) {
    object PersonalInfo : HomeBottomBarItem(
        route = "PersonalInfo",
        title = "Personal info",
        selectedIcon = Icons.Filled.PersonOutline,
        unselectedIcon = Icons.Outlined.PersonOutline,
    )

    object Education : HomeBottomBarItem(
        route = "EDUCATION",
        title = "Education",
        selectedIcon = Icons.Filled.School,
        unselectedIcon = Icons.Outlined.School,
    )

    object Skill : HomeBottomBarItem(
        route = "SKILL",
        title = "Skill",
        selectedIcon = Icons.Filled.Edit,
        unselectedIcon = Icons.Outlined.Edit,
    )
}