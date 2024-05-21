package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class StatusResponse(
    @SerializedName("isLinked")
    val isLinked: Boolean,
    @SerializedName("longUploadsStatus")
    val longUploadsStatus: String,
    @SerializedName("madeForKids")
    val madeForKids: Boolean,
    @SerializedName("privacyStatus")
    val privacyStatus: String,
    @SerializedName("selfDeclaredMadeForKids")
    val selfDeclaredMadeForKids: Boolean
)