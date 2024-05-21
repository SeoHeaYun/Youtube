package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class VideoEntity(
    val etag: String,
    val items: List<ItemEntity>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfoEntity,
    val prevPageToken: String
)