package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class SuggestionsEntity(
    val editorSuggestions: List<String>,
    val processingErrors: List<String>,
    val processingH1s: List<String>,
    val processingWarnings: List<String>,
    val tagSuggestions: List<TagSuggestionEntity>
)