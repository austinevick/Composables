package com.example.compose_reusable_components.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    isLoading: Boolean = false,
    text: String = "",
    onClick: () -> Unit
) {
    val localConfig = LocalConfiguration.current

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(localConfig.screenWidthDp.dp)
            .height(55.dp)
    ) {
        if (isLoading) CircularProgressIndicator() else Text(text = text)
    }
}