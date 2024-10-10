package com.example.compose_reusable_components.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun RadioButtonDialog(
    onDismissRequest: () -> Unit,
    onItemSelect: (String) -> Unit,
    selectedOption: String
) {

    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(8.dp))
        ) {
            splitOptions.forEach { item ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onItemSelect(item)
                            onDismissRequest()
                        }
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item, fontSize = 15.sp)
                    RadioButton(selected = selectedOption == item,
                        onClick = {
                            onItemSelect(item)
                            onDismissRequest()
                        })
                }
            }
        }
    }
}
val splitOptions =
    mutableStateListOf(
        "You paid and split equally", "Guest paid and split equally",
        "Owed full amount", "Owe full amount"
    )
