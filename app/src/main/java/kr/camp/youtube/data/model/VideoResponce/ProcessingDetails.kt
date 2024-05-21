package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class ProcessingDetailsResponse(
    @SerializedName("editorSuggestionsAvailability")
    val editorSuggestionsAvailability: String,
    @SerializedName("fileDetailsAvailability")
    val fileDetailsAvailability: String,
    @SerializedName("processingFailureReason")
    val processingFailureReason: String,
    @SerializedName("processingIssuesAvailability")
    val processingIssuesAvailability: String,
    @SerializedName("processingProgress")
    val processingProgress: ProcessingProgressResponse,
    @SerializedName("processingStatus")
    val processingStatus: String,
    @SerializedName("tagSuggestionsAvailability")
    val tagSuggestionsAvailability: String,
    @SerializedName("thumbnailsAvailability")
    val thumbnailsAvailability: String
)