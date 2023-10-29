package com.example.myportfolioadminapp.feature.my_skill.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myportfolioadminapp.feature.education_category.domain.model.get_all_education_category.AllEducationCategoryDataModel
import com.example.myportfolioadminapp.feature.skill_category.domain.model.response.get_all_categories.DataModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuComponent(
    selectedOptionText: String,
    allSkillCategories: List<DataModel>? = null,
    allEducationCategories: List<AllEducationCategoryDataModel>? = null,
    isLoading: Boolean,
    onMenuClick: (String) -> Unit,

    ) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(selectedOptionText) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            value = selectedOptionText,
            readOnly = true,
            onValueChange = {},
            label = { Text(text = "Category") },
            trailingIcon = {
                if (!isLoading) {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                } else {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(36.dp)
                            .padding(4.dp)
                    )
                }
            },
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {

            allSkillCategories?.forEach { data ->
                DropdownMenuItem(
                    text = { Text(text = data.title) },
                    onClick = {
                        selectedOptionText = data.title
                        expanded = false
                        onMenuClick(data.id)
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }

            allEducationCategories?.forEach { data ->
                DropdownMenuItem(
                    text = { Text(text = data.title) },
                    onClick = {
                        selectedOptionText = data.title
                        expanded = false
                        onMenuClick(data.id)
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }

}