package kr.camp.youtube.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val eTag: String?,
    @SerializedName("nextPageToken")
    val nextPageToken: String?,
    @SerializedName("regionCode")
    val regionCode: String?,
    @SerializedName("pageInfo")
    val pageInfo: PageInfoResponse?,
    @SerializedName("items")
    val items: List<ItemResponse>
)

data class PageInfoResponse(
    @SerializedName("totalResults")
    val totalResults: Int?,
    @SerializedName("resultsPerPage")
    val resultsPerPage: Int?
)

data class ItemResponse(
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("etag")
    val eTag: String?,
    @SerializedName("id")
    val id: IdResponse?,
    @SerializedName("snippet")
    val snippet: SnippetResponse
)

data class IdResponse(
    @SerializedName("kind")
    val kind: String,
    @SerializedName("videoId")
    val videoId: String
)

data class SnippetResponse(
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("channelId")
    val channelId: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnails")
    val thumbnails: ThumbnailsResponse,
    @SerializedName("channelTitle")
    val channelTitle: String,
    @SerializedName("liveBroadcastContent")
    val liveBroadcastContent: String,
    @SerializedName("publishTime")
    val publishTime: String,
)

data class ThumbnailsResponse(
    @SerializedName("default")
    val default: ThumbnailResponse,
    @SerializedName("medium")
    val medium: ThumbnailResponse,
    @SerializedName("high")
    val high: ThumbnailResponse
)

data class ThumbnailResponse(
    @SerializedName("url")
    val url: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int
)