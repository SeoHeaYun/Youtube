package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class RelatedPlaylistsResponse(
    @SerializedName("favorites")
    val favorites: String,
    @SerializedName("likes")
    val likes: String,
    @SerializedName("uploads")
    val uploads: String
)