package com.example.jetpack_compose.ui.first

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose.ui.firstRoute
import com.example.jetpack_compose.ui.first.contents.FavoriteView
import com.example.jetpack_compose.ui.first.contents.ListView

const val listRoute = "List"
const val favoriteRoute = "Favorite"

val contentsList: List<PageContents> = listOf(
    PageContents(listRoute, Icons.Default.List),
    PageContents(favoriteRoute, Icons.Default.Favorite)
)

data class PageContents(
    val navigationRoute: String,
    val icon: ImageVector
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstView(rootNavigation: NavHostController) {
    val contentsNavigation = rememberNavController()

    Scaffold(
        bottomBar = {
            Footer(
                rootNavigation,
                contentsNavigation,
                contentsList
            )
        },
        content = {
            NavHost(
                navController = contentsNavigation,
                startDestination = listRoute
            ) {
                composable(listRoute) { ListView() }
                composable(favoriteRoute) { FavoriteView() }
            }
        }
    )
}