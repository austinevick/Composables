package com.example.compose_reusable_components.customBottomSheet

import androidx.compose.foundation.gestures.AnchoredDraggableState
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomModalSheetContent(
    modifier: Modifier = Modifier,
    onValueChange: (Int) -> Unit = {},
    sheetMaxWidth: Dp = BottomSheetDefaults.SheetMaxWidth,
    shape: Shape,
    containerColor: Color = Color.Transparent,
    tonalElevation: Dp = BottomSheetDefaults.Elevation,
    contentWindowInsets: WindowInsets,
    content: @Composable ColumnScope.() -> Unit
) {
    val offsetY by remember { mutableFloatStateOf(0f) }

    Surface(
        modifier = modifier
            .widthIn(max = sheetMaxWidth)
            .fillMaxWidth()
            .pointerInput(Unit){
                detectDragGestures{change, dragAmount->
                    change.consume()
                    val delta = (dragAmount/5f).y.toInt()
                    onValueChange(-delta)
                }
            }
            .windowInsetsPadding(contentWindowInsets)
            .offset { IntOffset(0, offsetY.roundToInt()) },
        shape = shape,
        color = containerColor,
        tonalElevation = tonalElevation,
    ) {
        Column(
            Modifier
            .fillMaxWidth()
        ) { content() }
    }
}