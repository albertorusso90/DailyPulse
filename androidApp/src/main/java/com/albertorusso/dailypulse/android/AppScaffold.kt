package com.albertorusso.dailypulse.android

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.albertorusso.dailypulse.android.screens.AboutScreen
import com.albertorusso.dailypulse.android.screens.ArticlesScreen
import com.albertorusso.dailypulse.android.screens.Screen
import com.albertorusso.dailypulse.android.screens.SourcesScreen

@Composable
fun AppScaffold() {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screen.ARTICLES.route) {
            ArticlesScreen(
                onSourcesButtonClick = { navController.navigate(Screen.SOURCES.route) },
                onAboutButtonClick = { navController.navigate(Screen.ABOUT_DEVICE.route) }
            )
        }
        composable(Screen.SOURCES.route) {
            SourcesScreen(onUpButtonClick = { navController.popBackStack()} )
        }
        composable(Screen.ABOUT_DEVICE.route) {
            AboutScreen(
                onUpButtonClick = { navController.popBackStack() }
            )
        }
    }
}
