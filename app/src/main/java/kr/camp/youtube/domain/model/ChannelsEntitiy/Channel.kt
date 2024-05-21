package kr.camp.youtube.data.model.ChannelsResponce


import com.google.gson.annotations.SerializedName

data class ChannelEntity(
    val country: String,
    val defaultLanguage: String,
    val description: String,
    val keywords: String,
    val title: String,
    val trackingAnalyticsAccountId: String,
    val unsubscribedTrailer: String
)