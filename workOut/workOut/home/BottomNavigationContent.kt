package com.afrakhteh.learncompose.workOut.home

import androidx.annotation.DrawableRes

data class BottomNavigationContent(
    @DrawableRes val selectedIconId: Int,
    @DrawableRes val iconId: Int
)
