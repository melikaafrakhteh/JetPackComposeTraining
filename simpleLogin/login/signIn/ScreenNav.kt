package com.afrakhteh.learncompose.login.signIn

sealed class ScreenNav(val route: String){
    object LoginScreen: ScreenNav ("login")
    object SplashScreen: ScreenNav ("splash")
}
