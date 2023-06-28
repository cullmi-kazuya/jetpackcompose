package com.example.jetpack_compose.ui.first

import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.jetpack_compose.ui.secondViewRoute

@Composable
fun Footer(
    rootNavigation: NavHostController,
    contentsNavigation: NavHostController,
    contentsList: List<PageContents>
) {
    val navBackStackEntry by contentsNavigation.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar() {
        BottomAppBar(
            modifier = Modifier
                .height(75.dp),
            containerColor = Color.LightGray,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        rootNavigation.navigate(secondViewRoute)
                    },
                ) {
                    Icon(Icons.Filled.Add, "Floating Action Button")
                }
            },
            actions = {
                contentsList.forEach {
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { selected ->
                            selected.route == it.navigationRoute
                        } == true,
                        onClick = {
                            contentsNavigation.navigate(it.navigationRoute)
                        },
                        icon = {
                            Icon(it.icon, "Bottom Bar Icon")
                        }
                    )
                }
            }
        )
    }
}
