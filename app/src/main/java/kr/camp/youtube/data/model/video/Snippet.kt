package kr.camp.youtube.data.model.video


import com.google.gson.annotations.SerializedName

data class SnippetResponce(
    @SerializedName("categoryId")
    val categoryId: String?,
    @SerializedName("channelId")
    val channelId: String?,
    @SerializedName("channelTitle")
    val channelTitle: String,
    @SerializedName("defaultAudioLanguage")
    val defaultAudioLanguage: String?,
    @SerializedName("description")
    val description: String,
    @SerializedName("liveBroadcastContent")
    val liveBroadcastContent: String?,
    @SerializedName("localized")
    val localized: LocalizedResponce,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("tags")
    val tags: List<String>?,
    @SerializedName("thumbnails")
    val thumbnails: ThumbnailsResponce,
    @SerializedName("title")
    val title: String
)