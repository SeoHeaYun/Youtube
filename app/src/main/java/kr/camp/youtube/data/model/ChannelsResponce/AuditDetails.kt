package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class AuditDetailsResponse(
    @SerializedName("communityGuidelinesGoodStanding")
    val communityGuidelinesGoodStanding: Boolean,
    @SerializedName("contentIdClaimsGoodStanding")
    val contentIdClaimsGoodStanding: Boolean,
    @SerializedName("copyrightStrikesGoodStanding")
    val copyrightStrikesGoodStanding: Boolean,
    @SerializedName("overallGoodStanding")
    val overallGoodStanding: Boolean
)