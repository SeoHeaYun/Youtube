package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class LocalizationsResponse(
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)