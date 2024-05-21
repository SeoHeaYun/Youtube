package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class ItemEntity(
    val contentDetails: ContentDetailsEntity,
    val etag: String,
    val fileDetails: FileDetailsEntity,
    val id: String,
    val kind: String,
    val liveStreamingDetails: LiveStreamingDetailsEntity,
    val localizations: LocalizationsEntity,
    val player: PlayerEntity,
    val processingDetails: ProcessingDetailsEntity,
    val recordingDetails: RecordingDetailsEntity,
    val snippet: SnippetEntity,
    val statistics: StatisticsEntity,
    val status: StatusEntity,
    val suggestions: SuggestionsEntity,
    val topicDetails: TopicDetailsEntity
)