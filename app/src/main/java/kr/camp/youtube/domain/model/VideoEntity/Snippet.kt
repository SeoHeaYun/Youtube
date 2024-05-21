package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class SnippetEntity(
    val categoryId: String,
    val channelId: String,
    val channelTitle: String,
    val defaultAudioLanguage: String,
    val defaultLanguage: String,
    val description: String,
    val liveBroadcastContent: String,
    val localized: LocalizedEntity,
    val publishedAt: String,
    val tags: List<String>,
    val thumbnails: ThumbnailsEntity,
    val title: String
)