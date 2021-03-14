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

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.cart.Cart
import com.example.androiddevchallenge.ui.favorites.Favorites
import com.example.androiddevchallenge.ui.profile.Profile
import com.example.androiddevchallenge.ui.theme.BloomTheme
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector
) {
    object Home : Screen("home", R.string.home, Icons.Filled.Home)
    object Favorites : Screen("favorite", R.string.favorites, Icons.Filled.FavoriteBorder)
    object Profile : Screen("profile", R.string.profile, Icons.Filled.AccountCircle)
    object Cart : Screen("cart", R.string.cart, Icons.Filled.ShoppingCart)
}

val items = listOf(
    Screen.Home,
    Screen.Favorites,
    Screen.Profile,
    Screen.Cart
)

@Composable
fun Main() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .navigationBarsPadding()
                    .height(56.dp),
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
                elevation = BloomTheme.elevations.bottomNavigation
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo = navController.graph.startDestination
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = screen.icon,
                                contentDescription = stringResource(id = screen.resourceId),
                                modifier = Modifier.size(24.dp, 24.dp),
                                tint = MaterialTheme.colors.onPrimary
                            )
                        },
                        label = {
                            Text(
                                stringResource(id = screen.resourceId),
                                style = MaterialTheme.typography.caption
                            )
                        }
                    )
                }
            }
        }
    ) {
        NavHost(navController, startDestination = Screen.Home.route) {
            composable(Screen.Home.route) { Home() }
            composable(Screen.Favorites.route) { Favorites() }
            composable(Screen.Profile.route) { Profile() }
            composable(Screen.Cart.route) { Cart() }
        }
    }
}
