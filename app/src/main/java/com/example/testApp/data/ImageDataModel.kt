package com.example.testApp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageDataModel(
    val height: Int,
    val url: String,
    val width: Int
):Parcelable