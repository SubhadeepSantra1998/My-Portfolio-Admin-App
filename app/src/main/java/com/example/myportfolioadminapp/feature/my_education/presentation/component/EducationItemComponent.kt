package com.example.myportfolioadminapp.feature.my_education.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations.EducationModel


@Composable
fun EducationItemComponent(
    modifier: Modifier = Modifier,
    itemModel: EducationModel,
    onEducationUpdateIconClick:(String, String, String?) -> Unit,
    onEducationDeleteIconClick:(String, String, String?) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {
            Text(text = itemModel.institution)
            Text(text = itemModel.board)
            Text(text = itemModel.grade)
        }
        Row {
            IconButton(
                onClick = {onEducationUpdateIconClick(itemModel.id, itemModel.board, itemModel.course)}
            ) {
                Icon(imageVector = Icons.Default.Update, contentDescription = null)
            }
            IconButton(
                onClick = {onEducationDeleteIconClick(itemModel.id, itemModel.board, itemModel.course)}
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}