package kr.camp.youtube.data.model.ChannelsResponce


import com.google.gson.annotations.SerializedName

data class AuditDetailsEntity(
    val communityGuidelinesGoodStanding: Boolean,
    val contentIdClaimsGoodStanding: Boolean,
    val copyrightStrikesGoodStanding: Boolean,
    val overallGoodStanding: Boolean
)