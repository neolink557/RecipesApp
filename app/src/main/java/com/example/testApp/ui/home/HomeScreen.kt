package com.example.testApp.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testApp.data.RecipesResponseModel

private lateinit var viewModel: HomeViewModel

@Composable
fun HomeScreen(navController: NavHostController, homeViewModel: HomeViewModel) {
    viewModel = homeViewModel
    val result: RecipesResponseModel? by viewModel.recipes.observeAsState()
    viewModel.getRecipes("\"chicken\"")
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = result?.recipes?.get(0)?.recipe?.label ?: "", textAlign = TextAlign.Center, fontSize = 50.sp)
    }
    Log.d("test", result.toString())
}
