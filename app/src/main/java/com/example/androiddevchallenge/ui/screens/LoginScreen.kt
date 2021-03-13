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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.MySmootheButton
import com.example.androiddevchallenge.ui.components.MySootheTextField
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.buttonHeight
import com.example.androiddevchallenge.ui.theme.grid
import com.example.androiddevchallenge.ui.theme.grid4
import com.example.androiddevchallenge.ui.theme.screenPadding
import com.example.androiddevchallenge.ui.theme.taupe100
import com.example.androiddevchallenge.ui.theme.taupe800

@Composable
fun LoginScreen(darkTheme: Boolean = isSystemInDarkTheme(), navigateToHomeScreen: () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        val backgroundResource = if (darkTheme) R.drawable.ic_dark_login else R.drawable.ic_light_login
        Image(
            painterResource(backgroundResource),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "LOG IN",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.paddingFromBaseline(top = 200.dp),
                color = if (darkTheme) taupe100 else taupe800
            )

            MySootheTextField(
                value = "Email address",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = screenPadding, end = screenPadding, top = grid4),
            )

            MySootheTextField(
                value = "Password",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = screenPadding, end = screenPadding, top = grid),
            )

            MySmootheButton(
                onClick = {
                    navigateToHomeScreen()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = screenPadding, end = screenPadding, top = grid)
                    .height(buttonHeight)
            ) {
                Text(text = "LOG IN", style = MaterialTheme.typography.button)
            }

            Row() {
                Text(
                    text = "Don't have an account? ",
                    modifier = Modifier.paddingFromBaseline(top = 32.dp)
                )
                Text(
                    text = "Sign up",
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    modifier = Modifier.paddingFromBaseline(top = 32.dp)
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenLightPreview() {
    MySootheTheme {
        LoginScreen(darkTheme = false) {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenDarkPreview() {
    MySootheTheme(darkTheme = true) {
        LoginScreen(darkTheme = true) {}
    }
}
