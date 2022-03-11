package com.afrakhteh.learncompose.login.signIn

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.afrakhteh.learncompose.R
import com.afrakhteh.learncompose.ui.theme.Blue
import com.afrakhteh.learncompose.ui.theme.LightBlue
import com.afrakhteh.learncompose.ui.theme.Typography
import com.afrakhteh.learncompose.ui.theme.White

@Composable
fun SplashLoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageSection()
        TextSection()
        StartBtnSection(
            onClick = {
                navController.navigate(ScreenNav.LoginScreen.route)
            }
        )
    }
}

@Composable
fun ImageSection() {
    Image(
        painter = painterResource(id = R.drawable.login),
        contentDescription = "",
        modifier = Modifier
            .size(400.dp)
            .padding(horizontal = 24.dp)
    )
}

@Composable
fun TextSection() {
    Text(
        text = stringResource(R.string.spash_title),
        style = Typography.h2,
        color = White,
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun StartBtnSection(onClick: () -> Unit) {
    Text(
        text = stringResource(R.string.start),
        style = Typography.body2,
        color = White,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
            .clip(RoundedCornerShape(26.dp))
            .background(LightBlue)
            .padding(vertical = 16.dp, horizontal = 24.dp)
            .clickable { onClick() }

    )
}