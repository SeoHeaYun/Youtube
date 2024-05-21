package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class ProcessingProgressResponse(
    @SerializedName("partsProcessed")
    val partsProcessed: Double,
    @SerializedName("partsTotal")
    val partsTotal: Double,
    @SerializedName("timeLeftMs")
    val timeLeftMs: Double
)