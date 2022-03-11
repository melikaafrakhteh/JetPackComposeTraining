package com.afrakhteh.learncompose.login.signIn

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ScreenNav.SplashScreen.route) {

        composable(route = ScreenNav.SplashScreen.route) {
            SplashLoginScreen(navController)
        }
        composable(route = ScreenNav.LoginScreen.route) {
            LoginScreen()
        }
    }
}