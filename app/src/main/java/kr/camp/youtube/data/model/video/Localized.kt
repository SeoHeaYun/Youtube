package kr.camp.youtube.data.model.video


import com.google.gson.annotations.SerializedName

data class LocalizedResponce(
    @SerializedName("description")
    val description: String?,
    @SerializedName("title")
    val title: String?
)