package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.BloomTheme


@Composable
fun Welcome(onWelcomeFinish: () -> Unit) {
    BloomTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painterResource(R.drawable.ic_dark_welcome_bg),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 88.dp, top = 72.dp, bottom = 48.dp, end = 0.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_dark_welcome_illos),
                            contentDescription = null
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_dark_logo),
                        contentDescription = null,
                        modifier = Modifier.padding()
                    )
                    Text(
                        text = "Beautiful home garden solutions",
                        style = MaterialTheme.typography.subtitle1,
                        modifier = Modifier
                            .height(32.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                    Button(
                        onClick = { }, modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                    ) {
                        Text(
                            text = "Create account",
                            style = MaterialTheme.typography.button,
                            modifier = Modifier
                                .height(32.dp)
                                .fillMaxWidth()
                        )
                    }

                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.button,
                        modifier = Modifier
                            .height(32.dp)
                            .fillMaxHeight()
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewWelcome() {
    BloomTheme(darkTheme = true) {
        Welcome(onWelcomeFinish = { })
    }
}