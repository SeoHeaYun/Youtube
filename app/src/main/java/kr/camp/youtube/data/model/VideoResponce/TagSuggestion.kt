package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class TagSuggestionResponse(
    @SerializedName("categoryRestricts")
    val categoryRestricts: List<String>,
    @SerializedName("tag")
    val tag: String
)