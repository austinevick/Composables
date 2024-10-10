package com.example.compose_reusable_components.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    readOnly: Boolean = false,
    maxLines: Int = 1,
    singleLine: Boolean = true,
    isError: Boolean = false,
    textStyle: TextStyle = TextStyle.Default,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    Column {
        OutlinedTextField(
            value = value, onValueChange = onValueChange,
            placeholder = { Text(text = placeholder, color = Color.LightGray) },
            shape = RoundedCornerShape(8.dp),
            readOnly = readOnly,
            textStyle = textStyle.copy(color = Color.White),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                keyboardType = keyboardType
            ),
            visualTransformation = visualTransformation,
            singleLine = singleLine, maxLines = maxLines,
            isError = isError,
            modifier = modifier.fillMaxWidth(),
            trailingIcon = trailingIcon,
            leadingIcon =leadingIcon,
            colors = TextFieldDefaults.colors(

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Gray,
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            )
        )
        if (isError) Text(text = "Field is required", color = Color.Red)
    }

}