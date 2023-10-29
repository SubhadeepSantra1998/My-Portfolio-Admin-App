package com.example.myportfolioadminapp.feature.my_skill.presentation.my_skills

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.common.component.ConfirmationDialog
import com.example.myportfolioadminapp.common.component.ExpandableCardComponent
import com.example.myportfolioadminapp.feature.my_skill.presentation.components.ExtendedFabComponent
import com.example.myportfolioadminapp.route.MySkillRoute

@Composable
fun MySkillsScreen(
    navController: NavHostController, 
    paddingValue: PaddingValues,
    viewModel: MySkillsViewModel = hiltViewModel()
) {

    val listState = rememberLazyListState()
    val isExpanded by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }


    
    Scaffold(
        modifier = Modifier
            .padding(bottom = paddingValue.calculateBottomPadding())
            .padding(top = paddingValue.calculateTopPadding()),
        floatingActionButton = {
            ExtendedFabComponent(
                text = "Add Skill",
                expanded = isExpanded,
                onButtonClick = {
                    navController.navigate(MySkillRoute.AddSkill.route)
                }
            )
        },
    ) { padding ->

//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)
//                .padding(horizontal = 16.dp, vertical = 8.dp)
//        ) {



            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                state = listState,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(viewModel.uiState.mySkills){data->
                    data.skill?.let { skillModel->
                        ExpandableCardComponent(
                            icon = Icons.Default.AccountCircle,
                            title = data.title,
                            skillItems = skillModel,
                            onSkillUpdateIconClick = { skillId->
                                navController.navigate(MySkillRoute.UpdateSkill.route+"/${skillId}")
                            },
                            onSkillDeleteIconClick = { id , name ->
                                viewModel.onConfirmationDialogClicked(id , name)
                            }
                        )
                        if(viewModel.uiState.showDialog){
                            ConfirmationDialog(
                                title = "Delete",
                                message = "Are you sure want to delete ${viewModel.uiState.skillName} ?",
                                onConfirmation = viewModel::onDialogConfirm,
                                onDismissRequest = viewModel::onDialogDismiss
                            )
                        }
                    }
                }
            }
        //}
        
    }


    
    


    
}