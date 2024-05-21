package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class ContentDetailsResponse(
    @SerializedName("relatedPlaylists")
    val relatedPlaylists: RelatedPlaylistsResponse
)