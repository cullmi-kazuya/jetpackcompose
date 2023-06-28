package com.example.jetpack_compose.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetpack_compose.ui.theme.JetpackcomposeTheme

@Composable
fun Footer(navController: NavHostController, contentsList: List<PageContents>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar() {
        BottomAppBar(
            modifier = Modifier
                .height(75.dp),
            containerColor = Color.LightGray,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        /*TODO*/
                    },
                ) {
                    Icon(Icons.Filled.Add, "Localized description")
                }
            },
            actions = {
                contentsList.forEach {
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { selected ->
                            selected.route == it.navigationRoute
                        } == true,
                        onClick = {
                            navController.navigate(it.navigationRoute)
                        },
                        icon = {
                            Icon(it.icon, "List")
                        }
                    )
                }
            }
        )
    }
}
