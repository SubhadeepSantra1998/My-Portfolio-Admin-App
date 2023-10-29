package com.example.myportfolioadminapp.feature.my_education.presentation.my_education

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.common.component.ConfirmationDialog
import com.example.myportfolioadminapp.common.component.ExpandableCardComponent
import com.example.myportfolioadminapp.common.component.LinearLoadingBarComponent
import com.example.myportfolioadminapp.common.component.LoadingBarComponent
import com.example.myportfolioadminapp.common.component.PullRefreshComponent
import com.example.myportfolioadminapp.common.component.TitleTextComponent
import com.example.myportfolioadminapp.route.MyEducationRoute
import com.example.myportfolioadminapp.feature.my_skill.presentation.components.ExtendedFabComponent


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyEducationScreen(
    navController: NavHostController,
    paddingValue: PaddingValues,
    viewModel: MyEducationViewModel = hiltViewModel()
) {

    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()
    val isExpanded by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }
    val isRefreshing = uiState.isRefreshing
    val pullRefreshState =
        rememberPullRefreshState(isRefreshing, { viewModel.getAllMyEducations() })

    Scaffold(
        modifier = Modifier
            .padding(bottom = paddingValue.calculateBottomPadding()),
        floatingActionButton = {
            ExtendedFabComponent(
                text = "Add Education",
                expanded = isExpanded,
                onButtonClick = {
                    navController.navigate(MyEducationRoute.AddEducation.route)
                }
            )
        },
    ) { padding ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = padding.calculateBottomPadding())
                .pullRefresh(pullRefreshState)
        ) {
            if(!uiState.myEducation.isNullOrEmpty()){
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    state = listState,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(uiState.myEducation!!) { data ->
                        data.education?.let { educationModel ->
                            ExpandableCardComponent(
                                icon = Icons.Default.AccountCircle,
                                title = data.title,
                                educationItems = educationModel,
                                onEducationUpdateIconClick = { id, board, course ->
                                    //navController.navigate(SkillRoute.UpdateSkill.route + "/${skillId}")
                                    viewModel.onUpdateConfirmationDialog(id, board, course)
                                },
                                onEducationDeleteIconClick = { id, board, course ->
                                    viewModel.onDeleteConfirmationDialog(id, board, course)
                                }
                            )
                        }
                    }
                }
            }


            PullRefreshComponent(
                isRefreshing = isRefreshing,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )

            if (uiState.isLoading) {
                LoadingBarComponent(modifier = Modifier.align(Alignment.Center))
            }else{
                if(uiState.myEducation.isNullOrEmpty()){
                    TitleTextComponent(
                        text = "No data found",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            if (uiState.showUpdateDialog) {
                ConfirmationDialog(
                    title = "Update",
                    message = "Are you sure want to update ${uiState.board} ?",
                    onConfirmation = {
                        navController.navigate(MyEducationRoute.UpdateEducation.route +"/${uiState.educationId}")
                        viewModel.resetUpdateDialog()
                    },
                    onDismissRequest = viewModel::resetUpdateDialog
                )
            }


            if (uiState.showDeleteDialog) {
                ConfirmationDialog(
                    title = "Delete",
                    message = if(uiState.course!=null) "Are you sure want to delete ${uiState.course} ?" else "Are you sure want to delete ${uiState.board} ?",
                    onConfirmation = viewModel::onDialogDeleteConfirm,
                    onDismissRequest = viewModel::resetDeleteDialog
                )
            }

            if(uiState.isDeleteLoading){
                LinearLoadingBarComponent(
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }


            LaunchedEffect(key1 = uiState.isDeleteSuccess){
                viewModel.getAllMyEducations()
            }
        }
    }
}