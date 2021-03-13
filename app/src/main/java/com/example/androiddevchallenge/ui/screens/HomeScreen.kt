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

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.MySmootheCard
import com.example.androiddevchallenge.ui.components.MySootheTextField
import com.example.androiddevchallenge.ui.theme.MySootheTheme
import com.example.androiddevchallenge.ui.theme.grid
import com.example.androiddevchallenge.ui.theme.grid2
import com.example.androiddevchallenge.ui.theme.grid3
import com.example.androiddevchallenge.ui.theme.screenPadding

@Composable
fun HomeScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            bottomBar = {
                FabPosition.Center
                BottomAppBar(
                    elevation = 8.dp, backgroundColor = MaterialTheme.colors.background,
                    modifier = Modifier.padding(bottom = 48.dp)
                ) {
                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                        IconButton(onClick = {}, modifier = Modifier.weight(1f)) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.Spa, "Spa", modifier = Modifier.size(18.dp))
                                Text(text = "HOME", style = MaterialTheme.typography.caption)
                            }
                        }
                        IconButton(onClick = {}, modifier = Modifier.weight(1f)) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Default.AccountCircle, "Account Cirle", modifier = Modifier.size(18.dp))
                                Text(text = "PROFILE", style = MaterialTheme.typography.caption)
                            }
                        }
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {}, backgroundColor = MaterialTheme.colors.primary) {
                    Icon(Icons.Default.PlayArrow, "Play", modifier = Modifier.size(24.dp))
                }
            },
            floatingActionButtonPosition = FabPosition.Center,
            isFloatingActionButtonDocked = true
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
            ) {
                MySootheTextField(
                    value = "Search",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = screenPadding, end = screenPadding, top = 56.dp),
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Search", modifier = Modifier.size(18.dp))
                    }
                )

                Text(
                    text = "FAVORITE COLLECTIONS",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 40.dp)
                        .padding(horizontal = screenPadding)
                )

                FavoritesCollections()

                Text(
                    text = "ALIGN YOUR BODY",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 48.dp)
                        .padding(start = screenPadding, end = screenPadding, bottom = grid)
                )

                AlignYourBody()

                Text(
                    text = "ALIGN YOUR MIND",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(top = 48.dp)
                        .padding(start = screenPadding, end = screenPadding, bottom = grid)
                )

                AlignYourMind()
            }
        }
    }
}

@Composable
fun FavoritesCollections() {
    Row(
        modifier = Modifier
            .padding(start = grid, end = grid2)
            .horizontalScroll(rememberScrollState())
    ) {
        Column() {
            FavoritesCard(image = R.drawable.short_mantras, text = "Short mantras")
            FavoritesCard(image = R.drawable.nature_meditations, text = "Nature meditations")
        }
        Column() {
            FavoritesCard(image = R.drawable.stress_and_anxiety, text = "Stress and anxiety")
            FavoritesCard(image = R.drawable.self_massage, text = "Self-massage")
        }
        Column() {
            FavoritesCard(image = R.drawable.overwhelmed, text = "Overwhelmed")
            FavoritesCard(image = R.drawable.nightly_wind_down, text = "Nightly wind down")
        }
    }
}

@Composable
fun FavoritesCard(@DrawableRes image: Int, text: String) {
    MySmootheCard(
        modifier = Modifier
            .padding(top = grid, start = grid)
            .size(192.dp, 56.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(image),
                contentDescription = "Image of $text",
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = text,
                modifier = Modifier
                    .padding(start = grid2),
                style = MaterialTheme.typography.h3
            )
        }
    }
}

@Composable
fun AlignYourBody() {
    Row(
        modifier = Modifier
            .padding(start = grid, end = grid2)
            .horizontalScroll(rememberScrollState())
    ) {
        Circles(R.drawable.inversions, "Inversions")
        Circles(R.drawable.quick_yoga, "Quick yoga")
        Circles(R.drawable.stretching, "Stretching")
        Circles(R.drawable.tabata, "Tabata")
        Circles(R.drawable.hiit, "HIIT")
        Circles(R.drawable.pre_natal_yoga, "Pre-natal yoga")
    }
}

@Composable
fun AlignYourMind() {
    Row(
        modifier = Modifier
            .padding(start = grid, end = grid2)
            .horizontalScroll(rememberScrollState())
    ) {
        Circles(R.drawable.meditate, "Meditate")
        Circles(R.drawable.with_kids, "With kids")
        Circles(R.drawable.aromatherapy, "Aromatherapy")
        Circles(R.drawable.on_the_go, "On the go")
        Circles(R.drawable.with_pets, "With pets")
        Circles(R.drawable.high_stress, "High stress")
    }
}

@Composable
fun Circles(@DrawableRes image: Int, text: String) {
    Column(modifier = Modifier.padding(start = grid)) {
        Image(
            painterResource(image),
            contentDescription = "Image of $text",
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            text = text,
            modifier = Modifier
                .paddingFromBaseline(top = grid3),
            style = MaterialTheme.typography.h3
        )
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenLightPreview() {
    MySootheTheme {
        HomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenDarkPreview() {
    MySootheTheme(darkTheme = true) {
        HomeScreen()
    }
}

@Preview("Favorites Collections", widthDp = 624, heightDp = 136)
@Composable
fun FavoritesCollectionsPreview() {
    MySootheTheme() {
        Surface(color = MaterialTheme.colors.background) {
            FavoritesCollections()
        }
    }
}
