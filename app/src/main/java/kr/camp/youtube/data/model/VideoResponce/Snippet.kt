package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class SnippetResponse(
    @SerializedName("categoryId")
    val categoryId: String,
    @SerializedName("channelId")
    val channelId: String,
    @SerializedName("channelTitle")
    val channelTitle: String,
    @SerializedName("defaultAudioLanguage")
    val defaultAudioLanguage: String,
    @SerializedName("defaultLanguage")
    val defaultLanguage: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("liveBroadcastContent")
    val liveBroadcastContent: String,
    @SerializedName("localized")
    val localized: LocalizedResponse,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("thumbnails")
    val thumbnails: ThumbnailsResponse,
    @SerializedName("title")
    val title: String
)