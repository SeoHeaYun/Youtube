package kr.camp.youtube.data.model.ChannelsEntity


import com.google.gson.annotations.SerializedName

data class StatisticsEntity(
    val hiddenSubscriberCount: Boolean,
    val subscriberCount: Int,
    val videoCount: Int,
    val viewCount: Int
)