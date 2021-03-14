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
package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.BloomTheme
import com.example.androiddevchallenge.ui.theme.shapes
import com.example.androiddevchallenge.ui.theme.typography

@Composable
fun Welcome(onLoginClicked: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.primary) {
        Image(
            painter = painterResource(BloomTheme.images.welcomeBackground),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            alignment = Alignment.BottomCenter
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 72.dp, bottom = 48.dp)
            ) {
                Image(
                    painter = painterResource(BloomTheme.images.welcomeIllos),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 310.dp, height = 280.dp)
                        .offset(88.dp)
                )
            }
            Image(
                painter = painterResource(BloomTheme.images.welcomeLogo),
                contentDescription = null,
                modifier = Modifier.padding()
            )
            Text(
                text = stringResource(R.string.welcom_hint),
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .paddingFromBaseline(32.dp, 40.dp)
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier.padding(
                    top = 0.dp, bottom = 8.dp,
                    start = 16.dp, end = 16.dp
                )
            ) {
                Button(
                    onClick = { },
                    shape = BloomTheme.shapes.medium,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = stringResource(R.string.create_account),
                        style = MaterialTheme.typography.button,
                        textAlign = TextAlign.Center,
                    )
                }
            }

            TextButton(
                onClick = onLoginClicked,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp),
            ) {
                Text(
                    text = stringResource(R.string.login),
                    style = typography.button,
                    color = MaterialTheme.colors.secondaryVariant
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewWelcome() {
    BloomTheme(darkTheme = false) {
        Welcome(onLoginClicked = { })
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightDarkWelcome() {
    BloomTheme(darkTheme = true) {
        Welcome(onLoginClicked = { })
    }
}
