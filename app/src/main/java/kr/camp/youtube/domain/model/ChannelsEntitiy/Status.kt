package kr.camp.youtube.data.model.ChannelsEntity


import com.google.gson.annotations.SerializedName

data class StatusEntity(
    val isLinked: Boolean,
    val longUploadsStatus: String,
    val madeForKids: Boolean,
    val privacyStatus: String,
    val selfDeclaredMadeForKids: Boolean
)