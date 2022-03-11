package com.afrakhteh.learncompose.workOut.home

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.afrakhteh.learncompose.R
import com.afrakhteh.learncompose.ui.theme.*

@Composable
fun WorkOutHomeScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            GreetingHeader(name = "Melika", profileImage = R.drawable.profile)
            ChipsSection(itemList = listOf("Full body", "Cardio", "Cross fit", "Cycle"))
            MainCardSection()
            ProgressSection()
        }
        BottomNavigation(
            listOf(
                BottomNavigationContent(R.drawable.select_user, R.drawable.user),
                BottomNavigationContent(R.drawable.select_category, R.drawable.category),
                BottomNavigationContent(R.drawable.select_filter, R.drawable.filter),
                BottomNavigationContent(R.drawable.select_stopwatch, R.drawable.stopwatch),
            ),
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun GreetingHeader(name: String, profileImage: Int) {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = profileImage),
                contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Black,
                            fontWeight = FontWeight.Medium,
                            fontFamily = roboto,
                            fontSize = 16.sp
                        )
                    ) {
                        append("Hello, ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Black,
                            fontWeight = FontWeight.Bold,
                            fontFamily = roboto,
                            fontSize = 18.sp
                        )
                    ) {
                        append(name)
                    }
                }
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.noti),
            contentDescription = "notification",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    Toast
                        .makeText(
                            context,
                            "Click On Notification",
                            Toast.LENGTH_LONG
                        )
                        .show()
                }
        )
    }
}

@Composable
fun ChipsSection(itemList: List<String>) {
    var selectedItem by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(itemList.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
                    .clickable { selectedItem = it }
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (selectedItem == it) Black else NearWhite)
                    .border(1.dp, Gray, RoundedCornerShape(16.dp))
                    .padding(vertical = 10.dp, horizontal = 16.dp)
            ) {
                Text(
                    text = itemList[it],
                    color = if (selectedItem == it) NearWhite else Black,
                    fontFamily = roboto,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun MainCardSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(LightGray)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Loose \nbelly fat",
            style = Typography.h1,
            modifier = Modifier
                .align(Alignment.TopStart)
        )
        Text(
            text = stringResource(R.string.mid_level_text),
            style = Typography.h3,
            color = NearWhite,
            modifier = Modifier
                .padding(top = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Gray)
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .align(Alignment.TopEnd)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.dumble),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 32.dp)
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Row(
            modifier = Modifier.align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.clock),
                contentDescription = "timer",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.time),
                style = Typography.h3,
                color = Black
            )
        }
        Row(
            modifier = Modifier.align(Alignment.BottomEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.start),
                style = Typography.h2,
                color = Black
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "arrow",
                modifier = Modifier
                    .size(30.dp)
                    .padding(top = 8.dp)
            )
        }

    }
}

@Composable
fun ProgressSection() {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(LightPink),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleProgressBar(
            percent = 0.56f,
            number = 100
        )
        Column(verticalArrangement = Arrangement.SpaceAround) {
            Text(
                text = stringResource(R.string.great_text),
                style = Typography.h2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "You've lost 70% of your \ndaily calorie intake",
                style = Typography.body1
            )
        }
    }
}

@Composable
fun CircleProgressBar(
    percent: Float,
    number: Int,
    color: Color = Black,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0
) {
    var isAnimationPlayed by remember {
        mutableStateOf(false)
    }
    var currentPercent = animateFloatAsState(
        targetValue = if (isAnimationPlayed) percent else 0f,
        animationSpec = tween(animDuration, animDelay)
    )
    LaunchedEffect(key1 = true) {
        isAnimationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(50.dp * 2f)
            .padding(8.dp)
    ) {
        Canvas(
            modifier = Modifier.size(50.dp * 2f)
        ) {
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * currentPercent.value,
                useCenter = false,
                style = Stroke(
                    strokeWidth.toPx(), cap = StrokeCap.Round
                )
            )
        }
        Text(
            text = ((currentPercent.value * number).toInt()).toString() + "%",
            style = Typography.h2
        )
    }

}

@Composable
fun BottomNavigation(
    iconItem: List<BottomNavigationContent>,
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0
) {
    var selectedNavIndex by remember {
        mutableStateOf(selectedIndex)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
            .background(Black)
    ) {
        iconItem.forEachIndexed { index, bottomNavigationContent ->
            BottomNavigationItem(
                bottomContent = bottomNavigationContent,
                selectedNavIndex == index
            ) {
                selectedNavIndex = index
            }
        }
    }
}

@Composable
fun BottomNavigationItem(
    bottomContent: BottomNavigationContent,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    Image(
        painter =
        painterResource(id = checkIcon(bottomContent, isSelected)), contentDescription = "",
        modifier = Modifier.size(24.dp).clickable { onClick() }
    )
}

fun checkIcon(
    bottomContent: BottomNavigationContent,
    isSelected: Boolean = false
): Int {
    return if (isSelected) bottomContent.selectedIconId else bottomContent.iconId
}
