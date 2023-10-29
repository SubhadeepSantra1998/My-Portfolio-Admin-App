package com.example.myportfolioadminapp.feature.education_category.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Delete
import androidx.compose.material.icons.twotone.Update
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.example.myportfolioadminapp.common.component.BodyTextComponent
import com.example.myportfolioadminapp.common.component.SpacerHeightComponent
import com.example.myportfolioadminapp.common.component.TitleTextComponent
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

//@Composable
//fun CategoryListItem(
//    data: AllEducationCategoryDataModel,
//    viewModel: EducationCategoryViewModel
//) {
//
//    val update = SwipeAction(
//        icon = rememberVectorPainter(Icons.TwoTone.Update),
//        background = Color.Green,
//        onSwipe = { viewModel.onUpdateConfirmationDialog(data.id, data.title)}
//    )
//
//    val delete = SwipeAction(
//        icon = rememberVectorPainter(Icons.TwoTone.Delete),
//        background = Color.Red,
//        onSwipe = { viewModel.onDeleteConfirmationDialog(data.id, data.title)}
//    )
//
//    SwipeableActionsBox(
//        modifier = Modifier.clip(RoundedCornerShape(8.dp)),
//        startActions = listOf(update),
//        endActions = listOf(delete),
//        swipeThreshold = 48.dp
//    ){
//        Column(
//            modifier = Modifier
//                .padding(horizontal = 16.dp, vertical = 8.dp)
//
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Column {
//                    TitleTextComponent(text = data.title)
//
//                    SpacerHeightComponent(dp = 0.dp)
//                    BodyTextComponent(text = data.description)
//                }
//                Text(
//                    text = if (data.status !=0 ) "Active" else "Inactive",
//                    style = MaterialTheme.typography.labelLarge,
//                    color = if(data.status !=0) Color.Green else Color.Red
//                )
//            }
//        }
//    }
//
//
//}



@Composable
fun CategoryListItem(
    title: String,
    description: String,
    status: Int,
    onSwipeToUpdate:()-> Unit,
    onSwipeToDelete:()-> Unit,
) {

    val update = SwipeAction(
        icon = rememberVectorPainter(Icons.TwoTone.Update),
        background = Color.Green,
        onSwipe = { onSwipeToUpdate() }
    )

    val delete = SwipeAction(
        icon = rememberVectorPainter(Icons.TwoTone.Delete),
        background = Color.Red,
        onSwipe = { onSwipeToDelete() }
    )

    SwipeableActionsBox(
        modifier = Modifier.clip(RoundedCornerShape(8.dp)),
        startActions = listOf(update),
        endActions = listOf(delete),
        swipeThreshold = 48.dp
    ){
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    TitleTextComponent(text = title)

                    SpacerHeightComponent(dp = 0.dp)
                    BodyTextComponent(text = description)
                }
                Text(
                    text = if (status !=0 ) "Active" else "Inactive",
                    style = MaterialTheme.typography.labelLarge,
                    color = if(status !=0) Color.Green else Color.Red
                )
            }
        }
    }


}