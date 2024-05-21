package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class SuggestionsResponse(
    @SerializedName("editorSuggestions")
    val editorSuggestions: List<String>,
    @SerializedName("processingErrors")
    val processingErrors: List<String>,
    @SerializedName("processingH1s")
    val processingH1s: List<String>,
    @SerializedName("processingWarnings")
    val processingWarnings: List<String>,
    @SerializedName("tagSuggestions")
    val tagSuggestions: List<TagSuggestionResponse>
)