package com.example.jetpack_compose.ui

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose.ui.topContents.FavoriteView
import com.example.jetpack_compose.ui.topContents.ListView
import com.example.jetpack_compose.ui.theme.JetpackcomposeTheme


const val listNavigationRoute = "List"
const val favoriteNavigationRoute = "Favorite"

val contentsList: List<PageContents> = listOf(
    PageContents(listNavigationRoute, Icons.Default.List),
    PageContents(favoriteNavigationRoute, Icons.Default.Favorite)
)

data class PageContents(
    val navigationRoute: String,
    val icon: ImageVector
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopScreen() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            Header()
        },
        bottomBar = {
            Footer(navController, contentsList)
        },
        content = {
            NavHost(navController = navController, startDestination = listNavigationRoute) {
                composable(listNavigationRoute) { ListView() }
                composable(favoriteNavigationRoute) { FavoriteView() }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackcomposeTheme {
        TopScreen()
    }
}
