package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class SnippetResponse(
    @SerializedName("country")
    val country: String,
    @SerializedName("customUrl")
    val customUrl: String,
    @SerializedName("defaultLanguage")
    val defaultLanguage: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("localized")
    val localized: LocalizedResponse,
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("thumbnails")
    val thumbnails: ThumbnailsResponse,
    @SerializedName("title")
    val title: String
)