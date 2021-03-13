package com.example.androiddevchallenge.ui.home

import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.theme.BloomTheme

@Composable
fun Home(onLoginSuccess: () -> Unit) {
    BloomTheme {
        Surface {
            Button(
                onClick = onLoginSuccess,
            ) {
                Text(text = "Enter Home")
            }
        }
    }
}