package kr.camp.youtube.data.model.video


import com.google.gson.annotations.SerializedName

data class ItemResponce(
    @SerializedName("etag")
    val etag: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("snippet")
    val snippet: SnippetResponce
)