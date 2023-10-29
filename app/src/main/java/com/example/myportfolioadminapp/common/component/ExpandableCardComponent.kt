package com.example.myportfolioadminapp.common.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.myportfolioadminapp.feature.my_education.domain.model.response.get_all_educations.EducationModel
import com.example.myportfolioadminapp.feature.my_education.presentation.component.EducationItemComponent
import com.example.myportfolioadminapp.feature.my_skill.domain.model.allSkillsCategory.SkillModel
import com.example.myportfolioadminapp.feature.my_skill.presentation.components.SkillItemComponent


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExpandableCardComponent(
    icon: ImageVector,
    title: String,
    skillItems: List<SkillModel>? = null,
    educationItems: List<EducationModel>? = null,
    onSkillUpdateIconClick: ((String)-> Unit)? = null,
    onSkillDeleteIconClick: ((String, String) -> Unit)? = null,
    onEducationUpdateIconClick: ((String, String, String?) -> Unit)? = null,
    onEducationDeleteIconClick: ((String, String, String?) -> Unit)? = null,

    ) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(48.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                }
            }
            if (expandedState) {
//                LazyColumn(
//                    modifier = Modifier.padding(top = 8.dp),
//                    verticalArrangement = Arrangement.spacedBy(8.dp)
//                ){
//                    items(items){ item->
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .clickable {
//                                    onExpandedItemClick()
//                                }
//                        ) {
//                            Text(text = item.name)
//                            Text(text = item.proficiency.toString())
//                        }
//
//                    }
//                }
                FlowColumn(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    skillItems?.forEach { itemModel->

                        SkillItemComponent(
                            modifier = Modifier.fillMaxWidth(),
                            itemModel,
                            onSkillUpdateIconClick = {
                                if (onSkillUpdateIconClick != null) {
                                    onSkillUpdateIconClick(it)
                                }
                            },
                            onSkillDeleteIconClick = { id, name ->
                                if (onSkillDeleteIconClick != null) {
                                    onSkillDeleteIconClick(id , name)
                                }
                            }
                        )
                    }

                    educationItems?.forEach { itemModel->

                        EducationItemComponent(
                            modifier = Modifier.fillMaxWidth(),
                            itemModel,
                            onEducationUpdateIconClick = { id, board, course->
                                if (onEducationUpdateIconClick != null) {
                                    onEducationUpdateIconClick(id, board, course)
                                }
                            },
                            onEducationDeleteIconClick = { id, board, course ->
                                if (onEducationDeleteIconClick != null) {
                                    onEducationDeleteIconClick(id , board, course)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

