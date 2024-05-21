package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class TopicDetailsResponse(
    @SerializedName("topicCategories")
    val topicCategories: List<String>,
    @SerializedName("topicIds")
    val topicIds: List<String>
)