package kr.camp.youtube.data.model.ChannelsEntity


import com.google.gson.annotations.SerializedName

data class RelatedPlaylistsEntity(
    val favorites: String,
    val likes: String,
    val uploads: String
)