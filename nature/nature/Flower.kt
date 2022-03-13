package com.afrakhteh.learncompose.nature

import androidx.annotation.DrawableRes

data class Flower(
    val title: String,
    val price: String,
    val off: String = "0%",
    val isFave: Boolean = false,
    @DrawableRes val iconId: Int
)
