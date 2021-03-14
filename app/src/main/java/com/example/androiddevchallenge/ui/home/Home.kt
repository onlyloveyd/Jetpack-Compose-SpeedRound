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

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.PlantThemes
import com.example.androiddevchallenge.data.Plants
import com.example.androiddevchallenge.ui.theme.BloomTheme
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun Home() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .padding(bottom = 56.dp),
        color = BloomTheme.colors.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            var keyWord by remember { mutableStateOf("") }
            Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                TextField(
                    modifier = Modifier
                        .height(56.dp)
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color(0xFF9E9E9E),
                            shape = BloomTheme.shapes.small
                        ),
                    value = keyWord,
                    onValueChange = { keyWord = it },
                    maxLines = 1,
                    placeholder = {
                        Text(
                            text = "Search",
                            style = BloomTheme.typography.body1,
                        )
                    },
                    textStyle = BloomTheme.typography.body1,
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        textColor = BloomTheme.colors.onPrimary
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search"
                        )
                    },
                    singleLine = true
                )
            }
            Box(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                Text(
                    text = stringResource(id = R.string.browser_themes),
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Start,
                    color = BloomTheme.colors.onPrimary,
                    modifier = Modifier
                        .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                        .fillMaxWidth()
                )
            }

            Box(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .wrapContentSize()
            ) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(PlantThemes) { plantTheme ->
                        ThemeCard(plantTheme = plantTheme)
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.design_your_home_garden),
                    style = MaterialTheme.typography.h1,
                    textAlign = TextAlign.Start,
                    color = BloomTheme.colors.onPrimary,
                )
                Icon(
                    imageVector = Icons.Filled.FilterList,
                    contentDescription = "Filter List",
                    modifier = Modifier.size(24.dp, 24.dp),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.padding(start = 16.dp)) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(Plants) { plant ->
                        PlantCard(plant = plant)
                    }
                }
            }
        }
    }
}

@Preview(name = "Light Preview", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewHome() {
    BloomTheme(darkTheme = false) {
        Home()
    }
}

@Preview(name = "Dark Preview", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewHome() {
    BloomTheme(darkTheme = true) {
        Home()
    }
}
