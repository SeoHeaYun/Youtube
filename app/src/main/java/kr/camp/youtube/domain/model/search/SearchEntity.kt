package kr.camp.youtube.domain.model.search

data class SearchEntity(
    val kind: String?,
    val eTag: String?,
    val nextPageToken: String?,
    val prevPageToken: String?,
    val regionCode: String?,
    val pageInfo: PageInfoEntity?,
    val items: List<ItemEntity>
)

data class PageInfoEntity(
    val totalResults: Int?,
    val resultsPerPage: Int?
)

data class ItemEntity(
    val kind: String?,
    val eTag: String?,
    val id: IdEntity?,
    val snippet: SnippetEntity
)

data class IdEntity(
    val kind: String,
    val videoId: String
)

data class SnippetEntity(
    val publishedAt: String,
    val channelId: String,
    val title: String,
    val description: String,
    val thumbnails: ThumbnailsEntity,
    val channelTitle: String,
    val liveBroadcastContent: String,
    val publishTime: String,
)

data class ThumbnailsEntity(
    val default: ThumbnailEntity,
    val medium: ThumbnailEntity,
    val high: ThumbnailEntity
)

data class ThumbnailEntity(
    val url: String,
    val height: Int,
    val width: Int
)