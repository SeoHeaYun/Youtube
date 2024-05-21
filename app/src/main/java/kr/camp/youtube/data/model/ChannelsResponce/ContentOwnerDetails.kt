package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class ContentOwnerDetailsResponse(
    @SerializedName("contentOwner")
    val contentOwner: String,
    @SerializedName("timeLinked")
    val timeLinked: String
)