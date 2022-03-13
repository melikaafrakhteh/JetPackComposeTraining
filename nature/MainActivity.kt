package com.afrakhteh.learncompose

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.afrakhteh.learncompose.nature.NatureHomeScreen
import com.afrakhteh.learncompose.nature.NatureSplashScreen
import com.afrakhteh.learncompose.nature.Navigation

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
         // NatureSplashScreen()
          //  NatureHomeScreen()
            Navigation()
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   //NatureSplashScreen()
   // NatureHomeScreen()
}