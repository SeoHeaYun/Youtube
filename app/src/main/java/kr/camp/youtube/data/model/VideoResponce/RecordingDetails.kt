package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class RecordingDetailsResponse(
    @SerializedName("recordingDate")
    val recordingDate: String
)