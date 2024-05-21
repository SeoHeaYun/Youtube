package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class TopicDetailsResponse(
    @SerializedName("relevantTopicIds")
    val relevantTopicIds: List<String>,
    @SerializedName("topicCategories")
    val topicCategories: List<String>,
    @SerializedName("topicIds")
    val topicIds: List<String>
)