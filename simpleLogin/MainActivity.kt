package com.afrakhteh.learncompose

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.afrakhteh.learncompose.login.signIn.LoginScreen
import com.afrakhteh.learncompose.login.signIn.Navigation
import com.afrakhteh.learncompose.login.signIn.SplashLoginScreen

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          //LoginScreen()
            //SplashLoginScreen()
            Navigation()
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   // LoginScreen()
    //SplashLoginScreen()
}