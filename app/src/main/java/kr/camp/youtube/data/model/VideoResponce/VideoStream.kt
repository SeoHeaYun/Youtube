package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class VideoStreamResponse(
    @SerializedName("aspectRatio")
    val aspectRatio: Double,
    @SerializedName("bitrateBps")
    val bitrateBps: Double,
    @SerializedName("codec")
    val codec: String,
    @SerializedName("frameRateFps")
    val frameRateFps: Double,
    @SerializedName("heightPixels")
    val heightPixels: Int,
    @SerializedName("rotation")
    val rotation: String,
    @SerializedName("vendor")
    val vendor: String,
    @SerializedName("widthPixels")
    val widthPixels: Int
)