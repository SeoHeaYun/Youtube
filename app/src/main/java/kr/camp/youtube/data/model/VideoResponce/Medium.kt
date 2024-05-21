package kr.camp.youtube.data.model.VideoResponce


import com.google.gson.annotations.SerializedName

data class MediumResponce(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)