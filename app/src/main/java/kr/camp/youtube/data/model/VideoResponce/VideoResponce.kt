package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("etag")
    val etag: String,
    @SerializedName("items")
    val items: List<ItemResponse>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("nextPageToken")
    val nextPageToken: String,
    @SerializedName("pageInfo")
    val pageInfo: PageInfoResponse,
    @SerializedName("prevPageToken")
    val prevPageToken: String
)