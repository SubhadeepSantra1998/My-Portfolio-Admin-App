package com.example.myportfolioadminapp.feature.skill_category.presentation.show_categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.common.component.BackButtonComponent
import com.example.myportfolioadminapp.common.component.ConfirmationDialog
import com.example.myportfolioadminapp.common.component.HeadingTextComponent
import com.example.myportfolioadminapp.common.component.LinearLoadingBarComponent
import com.example.myportfolioadminapp.common.component.LoadingBarComponent
import com.example.myportfolioadminapp.common.component.PullRefreshComponent
import com.example.myportfolioadminapp.common.component.SpacerHeightComponent
import com.example.myportfolioadminapp.common.component.TitleTextComponent
import com.example.myportfolioadminapp.common.component.rememberSnackieState
import com.example.myportfolioadminapp.feature.education_category.presentation.components.CategoryListItem
import com.example.myportfolioadminapp.feature.my_skill.presentation.components.ExtendedFabComponent
import com.example.myportfolioadminapp.route.SkillCategoryRoute

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SkillCategoryScreen(
    navController: NavHostController,
    viewModel: SkillCategoryViewModel = hiltViewModel()
) {

    val listState = rememberLazyListState()
    val isExpanded by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val isRefreshing = uiState.isRefreshing
    val pullRefreshState = rememberPullRefreshState(isRefreshing, { viewModel.getAllCategories() })
    val snackbarState = rememberSnackieState()


    Scaffold(
        floatingActionButton = {
            ExtendedFabComponent(
                text = "Add Skill",
                expanded = isExpanded,
                onButtonClick = {
                    navController.navigate(SkillCategoryRoute.AddCategory.route)
                }
            )
        },
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(pullRefreshState)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = padding.calculateBottomPadding())
                    .padding(horizontal = 4.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BackButtonComponent(onClick = {
                        navController.navigateUp()
                    })
                    HeadingTextComponent(text = stringResource(id = R.string.skill_category))
                }


                SpacerHeightComponent(dp = 16.dp)
                if(!uiState.categories.isNullOrEmpty()){
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(uiState.categories!!) { categoryModel ->
                            CategoryListItem(
                                title = categoryModel.title,
                                description = categoryModel.description,
                                status = categoryModel.status,
                                onSwipeToUpdate = {
                                    viewModel.onUpdateConfirmationDialog(categoryModel.id, categoryModel.title)
                                },
                                onSwipeToDelete = {
                                    viewModel.onDeleteConfirmationDialog(categoryModel.id, categoryModel.title)
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
            }


            if (uiState.showUpdateDialog) {
                ConfirmationDialog(
                    title = "Update",
                    message = "Are you sure want to update ${uiState.categoryTitle} ?",
                    onConfirmation = {
                        navController.navigate(SkillCategoryRoute.UpdateCategory.route +"/${uiState.categoryId}")
                        uiState.showUpdateDialog = false
                    },
                    onDismissRequest = viewModel::onDialogDismiss
                )
            }

            if (uiState.showDeleteDialog) {
                ConfirmationDialog(
                    title = "Delete",
                    message = "Are you sure want to delete ${uiState.categoryTitle} ?",
                    onConfirmation = viewModel::onDialogDeleteConfirm,
                    onDismissRequest = viewModel::onDialogDismiss
                )
            }


            if(uiState.isDeleteLoading){
                LinearLoadingBarComponent(
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            if (uiState.isDeleteSuccess) {
                viewModel.getAllCategories()
            }


            if (uiState.categories?.isEmpty() == true) {
                TitleTextComponent(
                    text = "No data found",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}