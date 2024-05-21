package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class LiveStreamingDetailsEntity(
    val activeLiveChatId: String,
    val actualEndTime: String,
    val actualStartTime: String,
    val concurrentViewers: Int,
    val scheduledEndTime: String,
    val scheduledStartTime: String
)