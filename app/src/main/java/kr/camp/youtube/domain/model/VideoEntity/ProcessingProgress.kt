package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class ProcessingProgressEntity(
    val partsProcessed: Double,
    val partsTotal: Double,
    val timeLeftMs: Double
)