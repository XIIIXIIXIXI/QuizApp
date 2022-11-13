package com.example.quizapp.presentation.categoryScreens

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.ColorHistory
import kotlin.math.*

@Composable
fun CircularDragger(
    modifier: Modifier = Modifier,
    initialValue:Int,
    minValue:Int = 1,
    maxValue:Int = 50,
    colorOne: Color,
    colorTwo: Color,
    circleRadius:Float,
    onChange:(Int)->Unit
    ) {
    var position by remember {
        mutableStateOf(initialValue)
    }
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var startAngle by remember {
        mutableStateOf(0f)
    }
    var oldPosition by remember {
        mutableStateOf(initialValue)
    }

    var changeAngle by remember {
        mutableStateOf(0f)
    }

    Box(
        modifier = Modifier
    ) {
        Canvas(
            modifier = Modifier.pointerInput(true) {
                detectDragGestures(
                    onDragStart = { offset ->
                        startAngle = -atan2(
                            x = circleCenter.y - offset.y,
                            y = circleCenter.x - offset.x
                        ) * (180 / PI).toFloat()
                        //https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/atan2
                        //we get tha position from -180 to 180 we want it to 360 degrees
                        startAngle = startAngle.mod(360f)
                    },
                    onDrag = { change, _ ->
                        var touchAngle = -atan2(
                            x = circleCenter.y - change.position.y,
                            y = circleCenter.x - change.position.x
                        ) * (180 / PI).toFloat()
                        touchAngle = touchAngle.mod(360f)
                        //current angle
                        changeAngle = touchAngle - oldPosition * 360f / (maxValue - minValue)

                        //so the user can only drag from the position where it is.
                        val lowerThreshold =
                            oldPosition * 360f / (maxValue - minValue) - (360f / (maxValue - minValue) * 5)
                        val higherThreshold =
                            oldPosition * 360f / (maxValue - minValue) + (360f / (maxValue - minValue) * 5)

                        if (startAngle in lowerThreshold..higherThreshold) {
                            position =
                                (oldPosition + (changeAngle / (360f / (maxValue - minValue))).roundToInt())

                        }

                    },
                    onDragEnd = {
                        oldPosition = position
                        onChange(position)
                    }
                )
            }
                .fillMaxSize()
        ) {
            val height = size.height
            val width = size.width
            circleCenter = Offset(y = height / 2f, x = width / 2f)
            val thickness = width / 25f

            drawCircle(
                brush = Brush.radialGradient(
                    listOf(
                        colorOne.copy(0.0f),
                        colorTwo.copy(0.15f)
                    )
                ),
                center = circleCenter,
                radius = circleRadius
            )
            drawCircle(
                style = Stroke(
                    width = thickness
                ),
                center = circleCenter,
                radius = circleRadius,
                color = colorTwo

            )
            drawArc(
                style = Stroke(
                    cap = StrokeCap.Round,
                    width = thickness
                ),
                sweepAngle = (360f / maxValue) * position.toFloat(),
                startAngle = 270f,
                color = colorOne,
                size = Size(
                    height = circleRadius * 2f,
                    width = circleRadius * 2f,
                ),
                useCenter = false,
                topLeft = Offset(
                    (width - circleRadius * 2f) / 2f,
                    (height - circleRadius * 2f) / 2f
                )
            )

            drawContext.canvas.nativeCanvas.apply {
                drawIntoCanvas {
                    drawText(
                        "Number OF",
                        circleCenter.x,
                        circleCenter.y - 60.dp.toPx() / 3,
                        Paint().apply {
                            textSize = 25.sp.toPx()
                            textAlign = Paint.Align.CENTER
                            color = Color.White.toArgb()
                            isFakeBoldText = false
                        }
                    )
                    drawIntoCanvas {
                        drawText(
                            "Questions",
                            circleCenter.x,
                            circleCenter.y + 50.dp.toPx() / 3,
                            Paint().apply {
                                textSize = 25.sp.toPx()
                                textAlign = Paint.Align.CENTER
                                color = Color.White.toArgb()
                                isFakeBoldText = false
                            }
                        )
                        drawText(
                            "$position",
                            circleCenter.x,
                            circleCenter.y + 245.dp.toPx() / 3f,
                            Paint().apply {
                                textSize = 24.sp.toPx()
                                textAlign = Paint.Align.CENTER
                                color = colorOne.toArgb()
                                isFakeBoldText = true
                            }
                        )
                    }
                }

            }
        }
    }
}


    @Preview(showBackground = true)
    @Composable
    fun CircularDraggerPreview() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
                .padding(top = 16.dp,),
            contentAlignment = Alignment.Center
        ) {
            CircularDragger(
                modifier = Modifier.size(250.dp)
                    .background(Color.Gray),
                initialValue = 1,
                colorOne = ColorHistory,
                colorTwo = Color.Gray,
                circleRadius = 390f,
                onChange = { position ->
                    //do something with this
                })
        }
    }
