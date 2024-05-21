package kr.camp.youtube.data.model.VideoCategoriesresponse


import com.google.gson.annotations.SerializedName

data class SnippetResponse(
    @SerializedName("assignable")
    val assignable: Boolean,
    @SerializedName("channelId")
    val channelId: String,
    @SerializedName("title")
    val title: String
)