package kr.camp.youtube.data.model.VideoResponce


import com.google.gson.annotations.SerializedName

data class ThumbnailsResponce(
    @SerializedName("default")
    val default: DefaultResponce,
    @SerializedName("high")
    val high: HighResponce,
    @SerializedName("maxres")
    val maxres: MaxresResponce,
    @SerializedName("medium")
    val medium: MediumResponce,
    @SerializedName("standard")
    val standard: StandardResponce
)