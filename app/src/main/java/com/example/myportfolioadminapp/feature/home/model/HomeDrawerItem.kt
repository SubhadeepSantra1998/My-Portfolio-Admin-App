package com.example.myportfolioadminapp.feature.home.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.outlined.Android
import androidx.compose.material.icons.outlined.School
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myportfolioadminapp.route.EducationCategoryRoute
import com.example.myportfolioadminapp.route.SkillCategoryRoute



sealed class HomeDrawerItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
){
    object EducationCategory : HomeDrawerItem(
        title = "Education Category",
        route = EducationCategoryRoute.Home.route,
        selectedIcon = Icons.Filled.School,
        unselectedIcon = Icons.Outlined.School,
        badgeCount = 0
    )

    object SkillCategory : HomeDrawerItem(
        title = "Skill Category",
        route = SkillCategoryRoute.Home.route,
        selectedIcon = Icons.Filled.Android,
        unselectedIcon = Icons.Outlined.Android,
        badgeCount = 0
    )
}
