package kr.camp.youtube.data.model.VideoResponce


import com.google.gson.annotations.SerializedName

data class VideoResponce(
    @SerializedName("etag")
    val etag: String,
    @SerializedName("items")
    val items: List<ItemResponce>,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("nextPageToken")
    val nextPageToken: String,
    @SerializedName("pageInfo")
    val pageInfo: PageInfoResponce
)