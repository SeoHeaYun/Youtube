package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("embedHeight")
    val embedHeight: Double,
    @SerializedName("embedHtml")
    val embedHtml: String,
    @SerializedName("embedWidth")
    val embedWidth: Double
)