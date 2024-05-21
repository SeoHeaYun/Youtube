package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class ThumbnailsResponse(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)