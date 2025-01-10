package com.example.compose_reusable_components

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_reusable_components.customBottomSheet.CustomModalBottomSheet
import com.example.compose_reusable_components.ui.theme.ComposereusablecomponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposereusablecomponentsTheme {
                CustomBottomSheetSampleWithCanvas()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheetSampleWithCanvas() {

    val showBottomSheet = remember { mutableStateOf(false) }
    var valueLevel by remember { mutableIntStateOf(50) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Button(onClick = { showBottomSheet.value = showBottomSheet.value.not() }) {
                Text("Show Bottom Sheet")
            }

            if (showBottomSheet.value) {
                CustomModalBottomSheet(
                    shape = RoundedCornerShape(25.dp),
                    modifier = Modifier
                        .windowInsetsPadding(WindowInsets(18, 0, 18, 120))
                        .drawWithContent {
                            drawContent()
                            val width = 140f
                            val height = 160f

                            val point1 = 120f
                            val point2 = 120f

                            val path = Path().apply {
                                lineTo(size.width / 2 - width, 0f)
                                cubicTo(
                                    size.width / 2 - point1, 0f,
                                    size.width / 2 - point2, height,
                                    size.width / 2, height
                                )
                                cubicTo(
                                    size.width / 2 + point2, height,
                                    size.width / 2 + point1, 0f,
                                    size.width / 2 + width, 0f
                                )
                                lineTo(size.width / 2 + width, 0f)
                                close()
                            }
                            drawPath(path = path, Color.Transparent)
                        },
                    onDismissRequest = { showBottomSheet.value = false }) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxWidth()

                            .height(300.dp)
                            .background(Color.Red)
                    ) {
                        Text("Bottom Sheet")
                    }
                }
            }
        }
    }
}