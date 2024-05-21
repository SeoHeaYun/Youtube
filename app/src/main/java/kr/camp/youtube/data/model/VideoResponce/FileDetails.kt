package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class FileDetailsResponse(
    @SerializedName("audioStreams")
    val audioStreams: List<AudioStreamResponse>,
    @SerializedName("bitrateBps")
    val bitrateBps: Double,
    @SerializedName("container")
    val container: String,
    @SerializedName("creationTime")
    val creationTime: String,
    @SerializedName("durationMs")
    val durationMs: Double,
    @SerializedName("fileName")
    val fileName: String,
    @SerializedName("fileSize")
    val fileSize: Double,
    @SerializedName("fileType")
    val fileType: String,
    @SerializedName("videoStreams")
    val videoStreams: List<VideoStreamResponse>
)