package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class StatisticsResponse(
    @SerializedName("hiddenSubscriberCount")
    val hiddenSubscriberCount: Boolean,
    @SerializedName("subscriberCount")
    val subscriberCount: Int,
    @SerializedName("videoCount")
    val videoCount: Int,
    @SerializedName("viewCount")
    val viewCount: Int
)