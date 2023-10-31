package com.example.testApp.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageModel(
    @SerializedName("LARGE")
    val large: ImageDataModel,
    @SerializedName("REGULAR")
    val regular: ImageDataModel,
    @SerializedName("SMALL")
    val small: ImageDataModel,
    @SerializedName("THUMBNAIL")
    val thumbnail: ImageDataModel
): Parcelable