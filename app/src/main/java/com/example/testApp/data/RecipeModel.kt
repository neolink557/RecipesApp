package com.example.testApp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeModel(
    val calories: Double,
    val image: String,
    val images: ImageModel,
    val ingredientLines: List<String>,
    val label: String,
    val shareAs: String,
    val source: String,
    val totalTime: Double,
    val totalWeight: Double,
    val url: String,
    val yield: Double
):Parcelable