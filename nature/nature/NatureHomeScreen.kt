package com.afrakhteh.learncompose.nature

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.afrakhteh.learncompose.R
import com.afrakhteh.learncompose.ui.theme.*

@Composable
fun NatureHomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBrownBackground)
    ) {
        BackButtonSection()
        SearchSection()
        FilterItemSection(
            listOf("green", "wheat")
        )
        MostPopularSection(
            listOf(
                Flower(
                    title = "Wheat field",
                    price = "$564",
                    off = "0",
                    isFave = false,
                    R.drawable.image
                ),
                Flower(
                    title = "Green Ocean",
                    price = "$800",
                    off = "0",
                    isFave = true,
                    R.drawable.image2
                ),
                Flower(
                    title = "Green Lagoon",
                    price = "$504",
                    off = "-20%",
                    isFave = false,
                    R.drawable.imag3
                )
            )
        )
        BestPriceSection(
            listOf(
                Flower(
                    title = "Green Lagoon",
                    price = "$504",
                    off = "-20%",
                    isFave = false,
                    R.drawable.imag3
                ),
                Flower(
                    title = "Planet Of Fish",
                    price = "$900",
                    off = "-15%",
                    isFave = true,
                    R.drawable.image3
                )
            )
        )
    }
}

@Composable
fun BestPriceSection(flowers: List<Flower>) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().
            padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 4.dp)
        ) {
            Text(
                text = stringResource(id = R.string.best_text),
                style = Typography.h2
            )
            Text(
                text = stringResource(id = R.string.view_all_hint),
                style = Typography.h3
            )
        }
        LazyColumn() {
            items(flowers.size) {
                BestPrizeItem(flowers[it])
            }
        }
    }
}

@Composable
fun BestPrizeItem(flower: Flower) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 4.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(White)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(flower.iconId),
                contentDescription = "flower",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .size(80.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = flower.title, style = Typography.h3)
                Text(text = flower.price, style = Typography.h4)
            }

            Text(
                text = flower.off,
                style = Typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(NearBrown)
                    .padding(10.dp)
            )
    }
}

@Composable
fun MostPopularSection(items: List<Flower>) {
    Column() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 32.dp, bottom = 4.dp)
        ) {
            Text(
                text = stringResource(id = R.string.popular_text),
                style = Typography.h2
            )
            Text(
                text = stringResource(id = R.string.view_all_hint),
                style = Typography.h3
            )
        }
        LazyRow() {
            items(items.size) {
                PopularItem(items[it])
            }
        }
    }
}

@Composable
fun PopularItem(flower: Flower) {
    Column(
        modifier = Modifier
            .padding(start = 24.dp, top = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
        ) {
            Image(
                painter = painterResource(flower.iconId),
                contentDescription = "flower",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(130.dp)
                    .fillMaxHeight(0.4f)
            )
            Icon(
                painter = painterResource(id = checkIfFavoriteIsFalse(flower)),
                contentDescription = "like",
                tint = NearBrown,
                modifier = Modifier
                    .padding(top = 8.dp, start = 8.dp)
                    .size(30.dp)
                    .align(Alignment.TopStart)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = flower.title,
            style = Typography.h3
        )
        Text(
            text = flower.price,
            style = Typography.h4
        )

    }
}

fun checkIfFavoriteIsFalse(flower: Flower): Int {
    return if (flower.isFave) R.drawable.ic_favorite else R.drawable.ic_favorite_border
}

@Composable
fun FilterItemSection(list: List<String>) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(list.size) {
            FilterRecyclerView(list[it])
        }
    }
}

@Composable
fun FilterRecyclerView(item: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 24.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(White)
            .padding(top = 8.dp, start = 12.dp, end = 12.dp, bottom = 8.dp)
    ) {
        Text(text = item, style = Typography.body2)
        Spacer(modifier = Modifier.width(4.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_clear),
            contentDescription = "clear",
            tint = NearBrown,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun SearchSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 24.dp, start = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(White)
                .padding(horizontal = 24.dp, vertical = 8.dp),
        ) {
            var textState by remember { mutableStateOf("") }
            BasicTextField(
                value = textState,
                onValueChange = { textState = it },
                decorationBox = { innerTextField ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "search",
                            tint = LightBrown,
                            modifier = Modifier.size(24.dp)
                        )

                        if (textState.isEmpty()) {
                            Text(
                                text = stringResource(R.string.search_hint),
                                style = Typography.h3,
                                color = LightBrown
                            )
                        } else {
                            innerTextField()
                        }
                    }
                }
            )
        }

        FilterSection()
    }
}

@Composable
fun FilterSection() {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(White)
            .padding(8.dp)
            .clickable {
                Log.d("home", "filter")
            }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = "filter",
            tint = NearBrown,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
fun BackButtonSection() {
    Icon(
        painter = painterResource(id = R.drawable.ic_arrow_forward),
        contentDescription = "back",
        tint = Green,
        modifier = Modifier
            .scale(scaleX = -1f, scaleY = 1f)
            .padding(top = 4.dp, start = 24.dp, end = 24.dp)
            .size(32.dp)
    )
}
