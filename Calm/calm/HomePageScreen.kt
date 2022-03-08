package com.afrakhteh.learncompose.calm

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.afrakhteh.learncompose.R
import com.afrakhteh.learncompose.ui.theme.*

@ExperimentalFoundationApi
@Composable
fun BreakDownHomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Greeting(name = "Melika", profileImage = R.drawable.profile)
            NewMeditationSection(
                listOf(
                    NewMeditation(
                        "Water Therapy",
                        "If anxiety is a little over top",
                        "24 min",
                        R.drawable.water
                    ),
                    NewMeditation(
                        "Walk In Jungle",
                        "If anxiety is  More over top",
                        "40 min",
                        R.drawable.jungle
                    )
                )
            )
            RecommendationSection(
                recommendList = listOf(
                    Recommendation("Waves", "Reduce anxiety", R.drawable.wave),
                    Recommendation("Nature", "Deal with Stress", R.drawable.leaf),
                    Recommendation("Rain", "Reduce more anxiety", R.drawable.rain),
                    Recommendation("Wind", "Deal with Sadness", R.drawable.wind)
                )
            )
        }
        BottomNavigation(
            iconList = listOf(
                BottomMenuContent(R.drawable.home),
                BottomMenuContent(R.drawable.pen),
                BottomMenuContent(R.drawable.goal),
                BottomMenuContent(R.drawable.setting)
            ),
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}

@Composable
fun Greeting(name: String, profileImage: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(R.string.greet_title),
                style = Typography.h2
            )
            Text(
                text = name,
                style = Typography.h1
            )
        }
        Image(
            painter = painterResource(id = profileImage),
            contentDescription = "profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .border(2.dp, Gray, RoundedCornerShape(12.dp))
                .clipToBounds()
                .size(50.dp)
        )
    }
}

@Composable
fun NewMeditationSection(meditationList: List<NewMeditation>) {
    Column(
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(text = stringResource(R.string.new_title), style = Typography.h3)
            Text(text = stringResource(R.string.see_all), style = Typography.h3)
        }
        LazyRow {
            items(meditationList.size) {
                NewMeditationItemRow(meditation = meditationList[it])
            }
        }
    }
}

@Composable
fun NewMeditationItemRow(meditation: NewMeditation) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .width(240.dp)
            .height(240.dp)
            .clip(RoundedCornerShape(40.dp))
            .padding(bottom = 16.dp, start = 16.dp)

    ) {
        Image(
            painter = painterResource(id = meditation.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.align(Alignment.TopStart)) {
                Text(
                    text = meditation.title,
                    style = Typography.h2,
                    color = NearWhite,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = meditation.desc,
                    style = Typography.body1,
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TimerSection(time = meditation.time)

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Blue)
                        .padding(10.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.headphone),
                        contentDescription = "headphone",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TimerSection(time: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = R.drawable.timer),
            contentDescription = null,
            tint = NearWhite,
            modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = time,
            style = Typography.h4
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun RecommendationSection(recommendList: List<Recommendation>) {
    Column(modifier = Modifier.padding(bottom = 8.dp, start = 16.dp, end = 16.dp)) {
        Text(
            text = stringResource(R.string.recomend_title),
            style = Typography.h3
        )
        LazyHorizontalGrid(
            cells = GridCells.Fixed(2)
        ) {
            items(recommendList.size) {
                RecommendedItemRow(recommended = recommendList[it])
            }
        }
    }
}

@Composable
fun RecommendedItemRow(recommended: Recommendation) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .width(240.dp)
            .height(90.dp)
            .padding(end = 16.dp, top = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Blue)
            .padding(start = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(LightBlue)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = recommended.iconId),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = recommended.title, style = Typography.h2, color = NearWhite)
            Text(text = recommended.desc, style = Typography.body1)
        }
    }
}

@Composable
fun BottomNavigation(
    iconList: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    initialIndex: Int = 0
) {
    var selectedIndexState by remember {
        mutableStateOf(initialIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(84.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(DarkBlue)
            .padding(16.dp)
    ) {
        iconList.forEachIndexed {index, item ->
            BottomMenuItem(item, selectedIndexState == index) {
                selectedIndexState = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    onItemClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(if (isSelected) LightBlueShadow else Color.Transparent)
            .clickable { onItemClick() }
    ) {
        Icon(
            painter = painterResource(id = item.iconId),
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}