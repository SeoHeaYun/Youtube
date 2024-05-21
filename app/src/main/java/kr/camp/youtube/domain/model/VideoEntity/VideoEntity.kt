package kr.camp.youtube.domain.model.VideoEntity

data class VideoEntity(
    val etag: String,
    val items: List<ItemEntity>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfoEntity
)