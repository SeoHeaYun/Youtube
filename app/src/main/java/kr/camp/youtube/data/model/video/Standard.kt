package kr.camp.youtube.data.model.video


import com.google.gson.annotations.SerializedName

data class StandardResponce(
    @SerializedName("height")
    val height: Int?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?
)