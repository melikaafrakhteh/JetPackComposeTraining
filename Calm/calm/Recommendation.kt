package com.afrakhteh.learncompose.calm

import androidx.annotation.DrawableRes

data class Recommendation(
    val title: String,
    val desc: String,
    @DrawableRes val iconId: Int
)
