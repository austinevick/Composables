package com.example.compose_reusable_components.customBottomSheet

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomModalBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = BottomSheetDefaults.ExpandedShape,
    properties: ModalBottomSheetProperties = ModalBottomSheetDefaults.properties,
    contentWindowInsets: WindowInsets = BottomSheetDefaults.windowInsets,
    sheetContent: @Composable () -> Unit,
) {

    val predictiveBackProgress = remember { Animatable(initialValue = 0f) }
    var valueLevel by remember { mutableIntStateOf(0) }

    CustomBottomSheetDialog(
        onDismissRequest = onDismissRequest,
        properties = properties,
        predictiveBackProgress = predictiveBackProgress
    ) {

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            Scrim(
                color = Color.Black.copy(alpha = 0.3f),
                onDismissRequest = onDismissRequest, visible = true
            )
            CustomModalSheetContent(
                modifier = modifier,
                onValueChange = { delta ->
                    valueLevel = (valueLevel + delta).coerceIn(0, 100)
                    if (valueLevel == 0) {
                        onDismissRequest()
                    }
                },
                shape = shape,
                contentWindowInsets = contentWindowInsets
            ) {
                sheetContent()
            }
        }
    }

}
