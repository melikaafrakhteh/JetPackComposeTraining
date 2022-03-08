package com.afrakhteh.learncompose.calm

import androidx.annotation.DrawableRes

data class NewMeditation(
    val title: String,
    val desc: String,
    val time: String,
    @DrawableRes val image: Int
)
