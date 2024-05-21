package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class AudioStreamResponse(
    @SerializedName("bitrateBps")
    val bitrateBps: Double,
    @SerializedName("channelCount")
    val channelCount: Int,
    @SerializedName("codec")
    val codec: String,
    @SerializedName("vendor")
    val vendor: String
)