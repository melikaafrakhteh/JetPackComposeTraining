package com.afrakhteh.learncompose.nature

sealed class ScreenNav(val route: String) {
    object NatureSplash: ScreenNav("splash")
    object NatureHome: ScreenNav("home")
}
