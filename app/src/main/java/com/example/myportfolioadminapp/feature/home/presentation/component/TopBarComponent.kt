package com.example.myportfolioadminapp.feature.home.presentation.component

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.feature.home.model.HomeDrawerItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(
    navController: NavHostController,
    titleState: MutableState<String>,
    drawerMenus :List<HomeDrawerItem>,
    onDrawerMenuIconClick: () -> Unit,
) {


        if(titleState.value == "Personal info"){
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = onDrawerMenuIconClick,
                    ) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = stringResource(id = R.string.menu))
                    }
                },
                title = {
                    Text(text = titleState.value)
                }
            )
        }else{
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                            //titleState.value = "Personal info"
                        },
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = stringResource(id = R.string.menu))
                    }
                },
                title = {
                    Text(text = titleState.value)
                }
            )
        }


    }

