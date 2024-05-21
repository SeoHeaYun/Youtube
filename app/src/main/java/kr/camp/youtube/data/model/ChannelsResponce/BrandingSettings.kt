package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class BrandingSettingsResponse(
    @SerializedName("channel")
    val channel: ChannelResponse,
    @SerializedName("watch")
    val watch: WatchResponse
)