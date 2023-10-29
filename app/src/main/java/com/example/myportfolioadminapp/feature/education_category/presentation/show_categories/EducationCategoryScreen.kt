package com.example.myportfolioadminapp.feature.education_category.presentation.show_categories

import android.util.Log
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
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.common.component.BackButtonComponent
import com.example.myportfolioadminapp.common.component.ConfirmationDialog
import com.example.myportfolioadminapp.common.component.HeadingTextComponent
import com.example.myportfolioadminapp.common.component.LoadingBarComponent
import com.example.myportfolioadminapp.common.component.SpacerHeightComponent
import com.example.myportfolioadminapp.common.component.TitleTextComponent
import com.example.myportfolioadminapp.feature.education_category.presentation.components.CategoryListItem
import com.example.myportfolioadminapp.feature.education_category.presentation.viewModel.SharedViewModel
import com.example.myportfolioadminapp.feature.my_skill.presentation.components.ExtendedFabComponent
import com.example.myportfolioadminapp.route.EducationCategoryRoute


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EducationCategoryScreen(
    navController: NavHostController,
    viewModel: EducationCategoryViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = hiltViewModel()
) {

    val state = viewModel.uiState
//    val state1 by viewModel.state.collectAsStateWithLifecycle()
//    val updatedState by rememberUpdatedState(state1)
    val listState = rememberLazyListState()
    val isExpanded by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }

//    LaunchedEffect(updatedState) {
//        if (updatedState.categories != state1.categories) run {
//            viewModel.refreshData()
//        }
//    }
//
//    state1.let { uiState->
//
//        Log.d("hvjvjvj",uiState.categories.toString())
//    }


    //val isUpdateSuccessful by sharedViewModel.isUpdateCategorySuccessful.collectAsState()
//    Log.d("hvjvjvj", sharedViewModel.updateStatus.value)

    var sharedData by remember { mutableStateOf(sharedViewModel.updateStatus.value) }

    LaunchedEffect(sharedViewModel.updateStatus) {
        sharedData = sharedViewModel.updateStatus.value
    }

    Log.d("hvjvjvj", sharedData)


//    DisposableEffect(isUpdateSuccessful) {
//        if (isUpdateSuccessful) {
//            viewModel.refreshData()
//            sharedViewModel.resetUpdateStatus()
//        }
//        onDispose { }
//    }




    val isRefreshing = viewModel.uiState.isRefreshing
    val pullRefreshState = rememberPullRefreshState(isRefreshing, { viewModel.getAllEducationCategories() })

    Scaffold(
        floatingActionButton = {
            ExtendedFabComponent(
                text = "Add Category",
                expanded = isExpanded,
                onButtonClick = {
                    navController.navigate(EducationCategoryRoute.AddCategory.route)
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
                    HeadingTextComponent(text = stringResource(id = R.string.education_category))
                }


                SpacerHeightComponent(dp = 16.dp)


                if(!state.categories.isNullOrEmpty()){
//                    val categories = state1.categories!!
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(state.categories) { categoryModel ->
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

            if (state.showUpdateDialog) {
                ConfirmationDialog(
                    title = "Update",
                    message = "Are you sure want to update ${viewModel.uiState.categoryTitle} ?",
                    onConfirmation = {
                        navController.navigate(EducationCategoryRoute.UpdateCategory.route+"/${viewModel.uiState.categoryId}")
                        viewModel.uiState.showUpdateDialog = false
                                     },
                    onDismissRequest = viewModel::onDialogDismiss
                )
            }

            if (state.showDeleteDialog) {
                ConfirmationDialog(
                    title = "Delete",
                    message = "Are you sure want to delete ${viewModel.uiState.categoryTitle} ?",
                    onConfirmation = viewModel::onDialogDeleteConfirm,
                    onDismissRequest = viewModel::onDialogDismiss
                )
            }
            if (state.isLoading){
                LoadingBarComponent(modifier = Modifier.align(Alignment.Center))
            }
            if(state.categories?.isEmpty() == true){
                TitleTextComponent(text = "No data found",modifier = Modifier.align(Alignment.Center))
            }
            PullRefreshIndicator(
                refreshing = isRefreshing,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )

        }
    }
}