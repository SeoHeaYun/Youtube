package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class StatusResponse(
    @SerializedName("embeddable")
    val embeddable: Boolean,
    @SerializedName("failureReason")
    val failureReason: String,
    @SerializedName("license")
    val license: String,
    @SerializedName("madeForKids")
    val madeForKids: Boolean,
    @SerializedName("privacyStatus")
    val privacyStatus: String,
    @SerializedName("publicStatsViewable")
    val publicStatsViewable: Boolean,
    @SerializedName("publishAt")
    val publishAt: String,
    @SerializedName("rejectionReason")
    val rejectionReason: String,
    @SerializedName("selfDeclaredMadeForKids")
    val selfDeclaredMadeForKids: Boolean,
    @SerializedName("uploadStatus")
    val uploadStatus: String
)