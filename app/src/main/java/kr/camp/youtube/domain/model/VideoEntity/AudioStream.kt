package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class AudioStreamEntity(
    val bitrateBps: Double,
    val channelCount: Int,
    val codec: String,
    val vendor: String
)