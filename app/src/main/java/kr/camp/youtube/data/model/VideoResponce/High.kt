package kr.camp.youtube.data.model.VideoResponce


import com.google.gson.annotations.SerializedName

data class HighResponce(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)