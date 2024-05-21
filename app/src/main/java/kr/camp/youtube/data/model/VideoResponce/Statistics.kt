package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class StatisticsResponse(
    @SerializedName("commentCount")
    val commentCount: String,
    @SerializedName("dislikeCount")
    val dislikeCount: String,
    @SerializedName("favoriteCount")
    val favoriteCount: String,
    @SerializedName("likeCount")
    val likeCount: String,
    @SerializedName("viewCount")
    val viewCount: String
)