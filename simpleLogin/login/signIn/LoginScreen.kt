package com.afrakhteh.learncompose.login.signIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeOptions
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.afrakhteh.learncompose.R
import com.afrakhteh.learncompose.ui.theme.Blue
import com.afrakhteh.learncompose.ui.theme.Typography
import com.afrakhteh.learncompose.ui.theme.White

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        LoginTitleSection()
        EnterInformationSection()
        SignInSection()
        SignUpSection()
    }
}

@Composable
fun LoginTitleSection() {
    Text(
        text = stringResource(R.string.login_title),
        style = Typography.h1,
        modifier = Modifier.padding(top = 60.dp, start = 24.dp, bottom = 24.dp)
    )
}

@Composable
fun EnterInformationSection() {
    Column(modifier = Modifier.padding(24.dp)) {
        var emailText by rememberSaveable {
            mutableStateOf("")
        }
        var passWordText by rememberSaveable {
            mutableStateOf("")
        }
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(White),
            value = emailText,
            onValueChange = { emailText = it },
            label = { Text(stringResource(id = R.string.email_hint)) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = White,
                focusedIndicatorColor = Blue
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(White),
            value = passWordText,
            onValueChange = { passWordText = it },
            label = { Text(stringResource(id = R.string.pass_hint)) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = White,
                focusedIndicatorColor = Blue
            )
        )
    }
}

@Composable
fun SignInSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.sign_in_text),
            style = Typography.h3
        )
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Blue)

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "start",
                modifier = Modifier.size(36.dp).align(Alignment.Center),
                tint = Color.White
            )
        }
    }
}

@Composable
fun SignUpSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(vertical = 80.dp, horizontal = 24.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Sign up",
            style = Typography.body1)
        Text(
            text = "Forget Password",
            style = Typography.body1)
    }
}