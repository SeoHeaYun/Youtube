package kr.camp.youtube.data.model.VideoCategoriesresponse


import com.google.gson.annotations.SerializedName
import kr.camp.youtube.data.model.VideoCategoriesResponse.ItemResponse

data class VideoCategoriesResponse(
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