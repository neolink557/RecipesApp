package com.example.testApp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class RecipesResponseModel(
    @SerializedName("hits")
    val recipes: List<RecipesContainerModel>,
) : Parcelable