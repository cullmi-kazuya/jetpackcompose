package com.example.jetpack_compose.ui

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose.ui.first.FirstView
import com.example.jetpack_compose.ui.second.SecondView
import com.example.jetpack_compose.ui.theme.JetpackcomposeTheme

const val firstRoute = "First"
const val secondViewRoute = "Second"

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootView() {
    val rootNavigation = rememberNavController()

    Scaffold(
        topBar = {
            Header(rootNavigation)
        },
        content = {
            NavHost(
                navController = rootNavigation,
                startDestination = firstRoute
            ) {
                composable(firstRoute) { FirstView(rootNavigation) }
                composable(secondViewRoute) { SecondView() }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackcomposeTheme {
        RootView()
    }
}
