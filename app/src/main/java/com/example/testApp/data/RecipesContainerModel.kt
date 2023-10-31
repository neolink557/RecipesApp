package com.example.testApp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipesContainerModel(
    val recipe: RecipeModel
):Parcelable