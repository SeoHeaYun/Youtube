package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class ChannelResponse(
    @SerializedName("country")
    val country: String,
    @SerializedName("defaultLanguage")
    val defaultLanguage: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("keywords")
    val keywords: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("trackingAnalyticsAccountId")
    val trackingAnalyticsAccountId: String,
    @SerializedName("unsubscribedTrailer")
    val unsubscribedTrailer: String
)