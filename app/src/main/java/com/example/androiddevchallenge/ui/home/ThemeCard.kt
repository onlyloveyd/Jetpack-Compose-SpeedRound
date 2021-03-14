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
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PlantTheme
import com.example.androiddevchallenge.data.PlantThemes
import com.example.androiddevchallenge.ui.theme.BloomTheme

@Composable
fun ThemeCard(plantTheme: PlantTheme) {
    Card(
        shape = BloomTheme.shapes.small,
        elevation = BloomTheme.elevations.card,
        modifier = Modifier
            .wrapContentSize()
            .padding(bottom = 8.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {
        Column(modifier = Modifier.wrapContentSize()) {
            Image(
                painter = painterResource(id = plantTheme.cover),
                contentDescription = plantTheme.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(96.dp)
            )
            Text(
                text = plantTheme.name,
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Start,
                color = BloomTheme.colors.onPrimary,
                modifier = Modifier
                    .paddingFromBaseline(
                        top = 24.dp,
                        bottom = 16.dp,
                    )
                    .padding(start = 16.dp)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewThemeCard() {
    BloomTheme(darkTheme = false) {
        ThemeCard(PlantThemes[0])
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewThemeCard() {
    BloomTheme(darkTheme = false) {
        ThemeCard(PlantThemes[0])
    }
}
