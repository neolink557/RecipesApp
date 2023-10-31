package com.example.testApp.ui.home

import android.util.Log
import android.widget.ListView
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.testApp.R
import com.example.testApp.data.RecipesResponseModel
import com.google.android.material.math.MathUtils.lerp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

private lateinit var viewModel: HomeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: HomeViewModel) {
    viewModel = homeViewModel
    val result: RecipesResponseModel? by viewModel.recipes.collectAsState()
    val pagerState = rememberPagerState(Int.MAX_VALUE / 2)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 80.dp)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Here you have tasty recipes with chicken",
            fontSize = 35.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight(800)
        )
        Spacer(modifier = Modifier.height(100.dp))
        result?.let {
            if (it.recipes.size > 3) HorizontalMainPager(
                pagerState = pagerState,
                recipes = it
            )
        }
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalMainPager(pagerState: PagerState, recipes: RecipesResponseModel) {
    HorizontalPager(
        pageCount = Int.MAX_VALUE,
        state = pagerState,
        beyondBoundsPageCount = 2,
        contentPadding = PaddingValues(horizontal = 65.dp)
    ) { index ->
        Card(
            shape = RoundedCornerShape(24.dp),
            elevation = 10.dp,
            modifier = Modifier
                .height(400.dp)
                .graphicsLayer {
                    // Calculate the absolute offset for the current page from the
                    // scroll position. We use the absolute value which allows us to mirror
                    // any effects for both directions
                    val pageOffset = (
                            (pagerState.currentPage - index) + pagerState
                                .currentPageOffsetFraction
                            ).absoluteValue

                    lerp(
                        0.85f,
                        1f,
                        1f - pageOffset.coerceIn(0f, 1f)
                    ).also {
                        scaleX = it
                        scaleY = it
                    }

                }
        ) {
            Box(contentAlignment = Alignment.BottomStart) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            // Calculate the absolute offset for the current page from the
                            // scroll position. We use the absolute value which allows us to mirror
                            // any effects for both directions
                            val pageOffset = (
                                    (pagerState.currentPage - index) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            alpha = lerp(
                                0.6f,
                                1f,
                                1f - pageOffset.coerceIn(0f, 1f)
                            )
                        },
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(if (recipes.recipes[index % recipes.recipes.size].recipe.images.large != null) recipes.recipes[index % recipes.recipes.size].recipe.images.large.url else recipes.recipes[index % recipes.recipes.size].recipe.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(id = R.drawable.placeholder),
                    error = painterResource(id = R.drawable.placeholder)
                )
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                ) {
                    Text(
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 32.dp,
                            bottom = 8.dp
                        ),
                        text = recipes.recipes[index % recipes.recipes.size].recipe.label,
                        color = Color.White,
                        maxLines = 2,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(800),
                        fontSize = 32.sp
                    )
                    Text(
                        modifier = Modifier.padding(start = 18.dp,end = 16.dp ,bottom = 32.dp),
                        text = recipes.recipes[index % recipes.recipes.size].recipe.source,
                        color = Color.White,
                        maxLines = 2,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight(400),
                        fontSize = 16.sp
                    )
                }
            }

        }

        LaunchedEffect(key1 = pagerState) {
            launch {
                delay(3000)
                with(pagerState) {
                    val target = currentPage + 1

                    animateScrollToPage(
                        page = target
                    )
                }
            }
        }

    }
}
