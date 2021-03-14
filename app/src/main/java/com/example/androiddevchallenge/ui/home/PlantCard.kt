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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Plant
import com.example.androiddevchallenge.data.Plants
import com.example.androiddevchallenge.ui.theme.BloomTheme

@Composable
fun PlantCard(plant: Plant) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = plant.avatar),
            contentDescription = plant.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp, 64.dp)
                .clip(MaterialTheme.shapes.small)
        )
        Column(
            modifier = Modifier
                .weight(1.0f)
                .padding(start = 16.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = plant.name,
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Start,
                color = BloomTheme.colors.onPrimary,
                modifier = Modifier.paddingFromBaseline(top = 24.dp)
            )
            Text(
                text = plant.desc,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Start,
                color = BloomTheme.colors.onPrimary,
                modifier = Modifier.paddingFromBaseline(bottom = 24.dp)
            )
        }

        var checked by remember { mutableStateOf(false) }
        Checkbox(
            checked = checked, onCheckedChange = { checked = it },
            modifier = Modifier
                .size(24.dp, 24.dp)
                .padding(end = 16.dp)
        )
    }
    Divider(
        Modifier.padding(start = 72.dp, end = 16.dp)
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewPlantCard() {
    BloomTheme(darkTheme = false) {
        PlantCard(Plants[0])
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewPlantCard() {
    BloomTheme(darkTheme = false) {
        PlantCard(Plants[0])
    }
}
