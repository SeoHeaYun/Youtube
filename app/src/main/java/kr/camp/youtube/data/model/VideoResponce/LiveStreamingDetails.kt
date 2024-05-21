package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class LiveStreamingDetailsResponse(
    @SerializedName("activeLiveChatId")
    val activeLiveChatId: String,
    @SerializedName("actualEndTime")
    val actualEndTime: String,
    @SerializedName("actualStartTime")
    val actualStartTime: String,
    @SerializedName("concurrentViewers")
    val concurrentViewers: Int,
    @SerializedName("scheduledEndTime")
    val scheduledEndTime: String,
    @SerializedName("scheduledStartTime")
    val scheduledStartTime: String
)