package kr.camp.youtube.data.model.ChannelsEntity


import com.google.gson.annotations.SerializedName

data class SnippetEntity(
    val country: String,
    val customUrl: String,
    val defaultLanguage: String,
    val description: String,
    val localized: LocalizedEntity,
    val publishedAt: String,
    val thumbnails: ThumbnailsEntity,
    val title: String
)