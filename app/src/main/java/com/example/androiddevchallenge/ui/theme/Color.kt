/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)
val teal200 = Color(0xFF03DAC5)


val pink100 = Color(0xFFFFF1F1)
val pink900 = Color(0xFF3F2C2C)

val white = Color(0xFFFFFFFF)
val white850 = Color(0xFFFFFFFF)
val white150 = Color(0xFFFFFFFF)
//val white850 = Color(255F, 255F, 255F, 0.85F) // @todo white850
//val white150 = Color(255F, 255F, 255F, 0.15F) /// @todo white150
val gray = Color(0xFF232323)

val green900 = Color(0xFF2D3B2D)
val green300 = Color(0xFFB8C9B8)

/**
 * Return the fully opaque color that results from compositing [onSurface] atop [surface] with the
 * given [alpha]. Useful for situations where semi-transparent colors are undesirable.
 */
@Composable
fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}


