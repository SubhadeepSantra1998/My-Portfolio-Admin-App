package com.example.myportfolioadminapp.feature.home.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.feature.home.model.HomeDrawerItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun DrawerSheetComponent(
    scope: CoroutineScope,
    drawerState: DrawerState,
    navController: NavHostController,
) {

    val drawerMenus = listOf(
        HomeDrawerItem.EducationCategory,
        HomeDrawerItem.SkillCategory,
    )



    var selectedItemIndex by rememberSaveable {
        mutableStateOf(-1)
    }


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Header")
    }

    drawerMenus.forEachIndexed { index, item ->
        NavigationDrawerItem(
            label = { Text(text = item.title) },
            //selected = index == selectedItemIndex,
            selected = false,
            onClick = {
                selectedItemIndex = index
                scope.launch {
                    drawerState.close()
                }
                navController.navigate(item.route)
            },
            icon = {
                Icon(
                    imageVector = if (index == selectedItemIndex) {
                        item.selectedIcon
                    } else item.unselectedIcon,
                    contentDescription = item.title
                )
            },
            badge = {
                item.badgeCount?.let {
                    Text(text = item.badgeCount.toString())
                }
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }
}