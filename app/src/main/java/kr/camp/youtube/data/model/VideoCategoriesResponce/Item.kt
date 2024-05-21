package kr.camp.youtube.data.model.VideoCategoriesResponse


import com.google.gson.annotations.SerializedName
import kr.camp.youtube.data.model.VideoCategoriesresponse.SnippetResponse

data class ItemResponse(
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("snippet")
    val snippet: SnippetResponse
)