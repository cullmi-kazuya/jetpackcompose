package com.example.jetpack_compose.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route

    TopAppBar(
        title = {
            val title = when (currentRoute) {
                firstRoute -> "First View"
                secondViewRoute -> "Second View"
                else -> "First View"
            }
            Text(text = title)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray),
        navigationIcon = {
            val icon = when (currentRoute) {
                firstRoute -> Icons.Default.Home
                secondViewRoute -> Icons.Default.ArrowBack
                else -> Icons.Default.Home
            }
            val onClick: () -> Unit = when (currentRoute) {
                secondViewRoute -> {
                    { navController.popBackStack(firstRoute, false) }
                }
                else -> {
                    {}
                }
            }
            IconButton(onClick = onClick) {
                Icon(icon, "Header Icon")
            }
        }
    )
}
