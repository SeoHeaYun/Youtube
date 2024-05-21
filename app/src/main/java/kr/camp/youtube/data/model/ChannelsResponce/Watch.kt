package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class WatchResponse(
    @SerializedName("backgroundColor")
    val backgroundColor: String,
    @SerializedName("featuredPlaylistId")
    val featuredPlaylistId: String,
    @SerializedName("textColor")
    val textColor: String
)