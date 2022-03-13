package com.afrakhteh.learncompose.nature

import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenNav.NatureSplash.route
    ) {
        composable(route = ScreenNav.NatureSplash.route) {
            NatureSplashScreen(navController)
        }

        composable(route = ScreenNav.NatureHome.route) {
            NatureHomeScreen()
        }
    }
}