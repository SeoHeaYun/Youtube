package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class VideoStreamEntity(
    val aspectRatio: Double,
    val bitrateBps: Double,
    val codec: String,
    val frameRateFps: Double,
    val heightPixels: Int,
    val rotation: String,
    val vendor: String,
    val widthPixels: Int
)