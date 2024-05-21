package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class StatisticsEntity(
    val commentCount: String,
    val dislikeCount: String,
    val favoriteCount: String,
    val likeCount: String,
    val viewCount: String
)