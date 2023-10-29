package com.example.myportfolioadminapp.feature.my_skill.presentation.components

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
import com.example.myportfolioadminapp.feature.my_skill.domain.model.allSkillsCategory.SkillModel


@Composable
fun SkillItemComponent(
    modifier: Modifier = Modifier,
    itemModel: SkillModel,
    onSkillUpdateIconClick:(String) -> Unit,
    onSkillDeleteIconClick:(String, String) -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column {
            Text(text = itemModel.name)
            Text(text = itemModel.description)
            Text(text = itemModel.proficiency.toString())
        }
        Row {
            IconButton(
                onClick = {onSkillUpdateIconClick(itemModel.id)}
            ) {
                Icon(imageVector = Icons.Default.Update, contentDescription = null)
            }
            IconButton(
                onClick = {onSkillDeleteIconClick(itemModel.id, itemModel.name)}
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}