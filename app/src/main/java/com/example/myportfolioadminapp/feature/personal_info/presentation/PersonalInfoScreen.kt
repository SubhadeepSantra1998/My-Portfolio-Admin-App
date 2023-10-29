package com.example.myportfolioadminapp.feature.personal_info.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.myportfolioadminapp.R
import com.example.myportfolioadminapp.common.component.TitleTextComponent
import com.example.myportfolioadminapp.feature.home.presentation.component.DrawerSheetComponent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun PersonalInfoScreen(
    navController: NavHostController,
    paddingValue: PaddingValues,
    viewModel: PersonalInfoViewModel = hiltViewModel(),
) {

//    Column(
//        modifier = Modifier
//            .padding(bottom = paddingValue.calculateBottomPadding())
//            .padding(top = paddingValue.calculateTopPadding())
//            .padding(horizontal = 16.dp, vertical = 8.dp)
//            .verticalScroll(rememberScrollState())
//    ) {
//        HeadingTextComponent(text = stringResource(id = R.string.personal_info))
//
//        SpacerHeightComponent(16.dp)
//
//        IconOutlinedEditTextComponent(
//            textState = viewModel.uiState.name,
//            onTextChange = {
//                viewModel.onEvent(PersonalInfoUiEvent.NameChanged(it))
//            },
//            modifier = Modifier.fillMaxWidth(),
//            label = stringResource(id = R.string.name),
//            icon = Icons.Default.Person,
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
//            contentDescription = stringResource(id = R.string.name)
//        )
//
//        SpacerHeightComponent(16.dp)
//
//        IconOutlinedEditTextComponent(
//            textState = viewModel.uiState.designation,
//            onTextChange = {
//                viewModel.onEvent(PersonalInfoUiEvent.DesignationChanged(it))
//            },
//            modifier = Modifier.fillMaxWidth(),
//            label = stringResource(id = R.string.name),
//            icon = Icons.Default.Person,
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
//            contentDescription = stringResource(id = R.string.name)
//        )
//
//        SpacerHeightComponent(16.dp)
//
//        IconOutlinedEditTextComponent(
//            textState = viewModel.uiState.title,
//            onTextChange = {
//                viewModel.onEvent(PersonalInfoUiEvent.TitleChanged(it))
//            },
//            modifier = Modifier.fillMaxWidth(),
//            label = stringResource(id = R.string.name),
//            icon = Icons.Default.Person,
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
//            contentDescription = stringResource(id = R.string.name)
//        )
//
//        SpacerHeightComponent(16.dp)
//
//        IconOutlinedEditTextComponent(
//            textState = viewModel.uiState.description,
//            onTextChange = {
//                viewModel.onEvent(PersonalInfoUiEvent.DescriptionChanged(it))
//            },
//            modifier = Modifier.fillMaxWidth(),
//            label = stringResource(id = R.string.name),
//            icon = Icons.Default.Person,
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
//            contentDescription = stringResource(id = R.string.name)
//        )
//
//        SpacerHeightComponent(16.dp)
//
//        IconOutlinedEditTextComponent(
//            textState = viewModel.uiState.dob.toString(),
//            onTextChange = {
//                viewModel.onEvent(PersonalInfoUiEvent.DobChanged(it.toLong()))
//            },
//            modifier = Modifier.fillMaxWidth(),
//            label = stringResource(id = R.string.name),
//            icon = Icons.Default.Person,
//            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
//            contentDescription = stringResource(id = R.string.name)
//        )



    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val text by viewModel.text.observeAsState()




    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier
                    .padding(0.dp, 0.dp, 50.dp, 0.dp)
                    .fillMaxHeight()
            ) {
                DrawerSheetComponent(scope, drawerState, navController)
            }
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = paddingValue.calculateBottomPadding()),
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {
                        scope.launch { drawerState.open() }
                    }
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = stringResource(id = R.string.menu))
                }

                Text(text = "Personal info")

            }


            TypewriterAnimatedText(text = "Developer\nFreelancer\nPhotographer", loop = true)
        }
    }
}
@Composable
fun TypewriterAnimatedText(text: String, loop: Boolean = false) {
    var visibleText by remember { mutableStateOf("") }
    var showCursor by remember { mutableStateOf(false) }

    var looping by remember { mutableStateOf(loop) }

    LaunchedEffect(looping) {
        do {
            if (text.contains("\n")) {
                val lines = text.split("\n")
                for (line in lines) {
                    if (line.isNotBlank()) {
                        for (i in visibleText.indices.reversed()) {
                            visibleText = visibleText.removeRange(i, i + 1)
                            delay(30) // Delay to remove characters, adjust as needed
                        }
                        for (char in line) {
                            visibleText += char
                            showCursor = true
                            delay(100) // Delay between characters, adjust as needed
                            showCursor = false
                            delay(100) // Delay to show the cursor after each character, adjust as needed
                        }
                    }
                    delay(200) // Delay before starting the next line, adjust as needed
                }
            } else {
                for (char in text) {
                    visibleText += char
                    showCursor = true
                    delay(100) // Delay between characters, adjust as needed
                    showCursor = false
                    delay(100) // Delay to show the cursor after each character, adjust as needed
                }
            }
        }while(looping)
    }

    DisposableEffect(Unit) {
        onDispose {
            looping = false // Stop the animation loop when the composable is disposed
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        TitleTextComponent(text = "I'm ")
        TitleTextComponent(text = visibleText)
        if (showCursor) {
            Cursor()
        }
    }
}

@Composable
fun Cursor() {
    Box(
        modifier = Modifier
            .width(2.dp)
            .height(20.dp)
            .background(Color.Black)
    )
}