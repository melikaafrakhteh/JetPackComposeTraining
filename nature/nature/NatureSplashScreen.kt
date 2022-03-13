package com.afrakhteh.learncompose.nature

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.afrakhteh.learncompose.R
import com.afrakhteh.learncompose.ui.theme.Green
import com.afrakhteh.learncompose.ui.theme.LightBrown
import com.afrakhteh.learncompose.ui.theme.Typography
import com.afrakhteh.learncompose.ui.theme.roboto
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun NatureSplashScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        val systemUiController: SystemUiController = rememberSystemUiController()
        systemUiController.isStatusBarVisible = false // Status bar
        systemUiController.isNavigationBarVisible = false // Navigation bar
        systemUiController.isSystemBarsVisible = false // Status & Navigation bars

        BackGroundImageSection(R.drawable.backgound)
        SkipTextSection(
            stringResource(id = R.string.skip),
            modifier = Modifier.align(Alignment.TopEnd)
        )
        MainTextSection(
            stringResource(id = R.string.splash_desc),
            modifier = Modifier.align(Alignment.TopStart)
        )
        StartHomePageSection(
            modifier = Modifier.align(Alignment.BottomStart),
            painterResource(id = R.drawable.ic_arrow_forward),
        ){
            navController.navigate(ScreenNav.NatureHome.route)
        }
    }
}

@Composable
fun StartHomePageSection(modifier: Modifier, iconId: Painter, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .padding(24.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(LightBrown)
            .padding(18.dp)
            .clickable {onClick()}
    ) {
        Icon(
            painter = iconId,
            contentDescription = "next",
            tint = Green,
            modifier = modifier.size(30.dp)
        )
    }
}

@Composable
fun MainTextSection(stringDesc: String, modifier: Modifier) {
    Column(modifier = modifier.padding(start = 24.dp, top = 60.dp)) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Green,
                        fontSize = 30.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append(stringResource(id = R.string.splash_light_title) + " ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Green,
                        fontSize = 32.sp,
                        fontFamily = roboto,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(stringResource(id = R.string.splash_bold_title))
                }
            }
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = stringDesc,
            style = Typography.body1
        )
    }
}

@Composable
fun SkipTextSection(
    stringResource: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource,
        style = Typography.h2,
        color = Green,
        modifier = modifier.padding(top = 24.dp, end = 24.dp)
    )
}

@Composable
fun BackGroundImageSection(background: Int) {
    Image(
        painter = painterResource(id = background),
        contentDescription = "",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
