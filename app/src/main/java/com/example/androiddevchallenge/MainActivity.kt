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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.HomeScreen
import com.example.androiddevchallenge.ui.screens.LoginScreen
import com.example.androiddevchallenge.ui.screens.WelcomeScreen
import com.example.androiddevchallenge.ui.theme.MySootheTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                MySootheApp()
            }
        }
    }
}

@Composable
fun MySootheApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { NavActions(navController) }

    NavHost(navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navigateToLoginScreen = actions.navigateToLoginScreen) }
        composable("login") { LoginScreen(navigateToHomeScreen = actions.navigateToHomeScreen) }
        composable("home") { HomeScreen() }
    }
}

class NavActions(navController: NavHostController) {
    val navigateToLoginScreen: () -> Unit = {
        navController.navigate("login")
    }

    val navigateToHomeScreen: () -> Unit = {
        navController.navigate("home")
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MySootheTheme {
        MySootheApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MySootheTheme(darkTheme = true) {
        MySootheApp()
    }
}
