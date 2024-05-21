package kr.camp.youtube.data.model.VideoCategoriesEntity


import com.google.gson.annotations.SerializedName

data class VideoCategoriesEntity(
    val etag: String,
    val items: List<ItemEntity>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfoEntity,
    val prevPageToken: String
)