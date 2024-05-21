package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class FileDetailsEntity(
    val audioStreams: List<AudioStreamEntity>,
    val bitrateBps: Double,
    val container: String,
    val creationTime: String,
    val durationMs: Double,
    val fileName: String,
    val fileSize: Double,
    val fileType: String,
    val videoStreams: List<VideoStreamEntity>
)