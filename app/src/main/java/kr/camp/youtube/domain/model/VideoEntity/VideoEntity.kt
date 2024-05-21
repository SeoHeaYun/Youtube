package kr.camp.youtube.data.model.VideoEntity


data class VideoEntity(
    val etag: String,
    val items: List<ItemEntity>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfoEntity,
    val prevPageToken: String
)