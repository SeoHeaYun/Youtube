package kr.camp.youtube.data.model.ChannelsResponse


import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("auditDetails")
    val auditDetails: AuditDetailsResponse,
    @SerializedName("brandingSettings")
    val brandingSettings: BrandingSettingsResponse,
    @SerializedName("contentDetails")
    val contentDetails: ContentDetailsResponse,
    @SerializedName("contentOwnerDetails")
    val contentOwnerDetails: ContentOwnerDetailsResponse,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("localizations")
    val localizations: LocalizationsResponse,
    @SerializedName("snippet")
    val snippet: SnippetResponse,
    @SerializedName("statistics")
    val statistics: StatisticsResponse,
    @SerializedName("status")
    val status: StatusResponse,
    @SerializedName("topicDetails")
    val topicDetails: TopicDetailsResponse,
)

