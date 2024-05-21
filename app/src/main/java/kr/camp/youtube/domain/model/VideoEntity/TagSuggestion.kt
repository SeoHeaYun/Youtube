package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class TagSuggestionEntity(
    val categoryRestricts: List<String>,
    val tag: String
)