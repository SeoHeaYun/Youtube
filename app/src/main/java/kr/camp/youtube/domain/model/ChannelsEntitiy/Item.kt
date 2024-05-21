package kr.camp.youtube.data.model.ChannelsEntity


import com.google.gson.annotations.SerializedName
import kr.camp.youtube.data.model.ChannelsResponce.AuditDetailsEntity

data class ItemEntity(
    val auditDetails: AuditDetailsEntity,
    val brandingSettings: BrandingSettingsEntity,
    val contentDetails: ContentDetailsEntity,
    val contentOwnerDetails: ContentOwnerDetailsEntity,
    val etag: String,
    val id: String,
    val kind: String,
    val localizations: LocalizationsEntity,
    val snippet: SnippetEntity,
    val statistics: StatisticsEntity,
    val status: StatusEntity,
    val topicDetails: TopicDetailsEntity,
)