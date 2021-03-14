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

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R

private val LightImages = Images(
    welcomeBackground = R.drawable.ic_light_welcome_bg,
    welcomeIllos = R.drawable.ic_light_welcome_illos,
    welcomeLogo = R.drawable.ic_light_logo
)

private val DarkImages = Images(
    welcomeBackground = R.drawable.ic_dark_welcome_bg,
    welcomeIllos = R.drawable.ic_dark_welcome_illos,
    welcomeLogo = R.drawable.ic_dark_logo
)

private val AllElevations = Elevations(
    card = 1.dp,
    snackBar = 2.dp,
    bottomNavigation = 16.dp,
)

private val LightColorPalette = lightColors(
    primary = pink100,
    secondary = pink900,
    secondaryVariant = pink900, // 处理登录界面Login 字体颜色
    background = white,
    surface = white850,
    onPrimary = gray,
    onSecondary = white,
    onBackground = gray,
    onSurface = gray
)

private val DarkColorPalette = darkColors(
    primary = green900,
    secondary = green300,
    secondaryVariant = white, // 处理登录界面Login 字体颜色
    background = gray,
    surface = white150,
    onPrimary = white,
    onSecondary = gray,
    onBackground = white,
    onSurface = white850
)

@Composable
fun BloomTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val images = if (darkTheme) DarkImages else LightImages
    val elevations = AllElevations

    CompositionLocalProvider(
        localImages provides images,
        localElevations provides elevations
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object BloomTheme {
    val colors: Colors
        @Composable
        get() = MaterialTheme.colors

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    val images: Images
        @Composable
        get() = localImages.current

    val elevations: Elevations
        @Composable
        get() = localElevations.current
}
