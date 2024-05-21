package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class TopicDetailsEntity(
    val relevantTopicIds: List<String>,
    val topicCategories: List<String>,
    val topicIds: List<String>
)