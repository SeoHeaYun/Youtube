package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class ProcessingDetailsEntity(
    val editorSuggestionsAvailability: String,
    val fileDetailsAvailability: String,
    val processingFailureReason: String,
    val processingIssuesAvailability: String,
    val processingProgress: ProcessingProgressEntity,
    val processingStatus: String,
    val tagSuggestionsAvailability: String,
    val thumbnailsAvailability: String
)