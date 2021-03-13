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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.MySmootheButton
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.buttonHeight
import com.example.androiddevchallenge.ui.theme.grid
import com.example.androiddevchallenge.ui.theme.grid4
import com.example.androiddevchallenge.ui.theme.screenPadding

@Composable
fun WelcomeScreen(darkTheme: Boolean = isSystemInDarkTheme(), navigateToLoginScreen: () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        val backgroundResource = if (darkTheme) R.drawable.ic_dark_welcome else R.drawable.ic_light_welcome
        Image(
            painterResource(backgroundResource),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            val logoResource = if (darkTheme) R.drawable.ic_dark_logo else R.drawable.ic_light_logo
            Image(
                painterResource(logoResource),
                contentDescription = "MySmoothe logo"
            )

            MySmootheButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = screenPadding, end = screenPadding, top = grid4, bottom = grid)
                    .height(buttonHeight)
            ) {
                Text(text = "SIGN UP", style = MaterialTheme.typography.button)
            }

            MySmootheButton(
                onClick = {
                    navigateToLoginScreen()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(buttonHeight)
                    .padding(horizontal = screenPadding),
                colors = buttonColors(backgroundColor = MaterialTheme.colors.secondary)
            ) {
                Text(text = "LOG IN", style = MaterialTheme.typography.button)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenLightPreview() {
    MySootheTheme {
        WelcomeScreen(darkTheme = false) {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenDarkPreview() {
    MySootheTheme(darkTheme = true) {
        WelcomeScreen(darkTheme = true) {}
    }
}
