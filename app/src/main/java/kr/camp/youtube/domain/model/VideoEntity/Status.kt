package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class StatusEntity(
    val embeddable: Boolean,
    val failureReason: String,
    val license: String,
    val madeForKids: Boolean,
    val privacyStatus: String,
    val publicStatsViewable: Boolean,
    val publishAt: String,
    val rejectionReason: String,
    val selfDeclaredMadeForKids: Boolean,
    val uploadStatus: String
)