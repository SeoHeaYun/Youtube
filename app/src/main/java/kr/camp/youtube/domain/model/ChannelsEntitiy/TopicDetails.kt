package kr.camp.youtube.data.model.ChannelsEntity


import com.google.gson.annotations.SerializedName

data class TopicDetailsEntity(
    val topicCategories: List<String>,
    val topicIds: List<String>
)