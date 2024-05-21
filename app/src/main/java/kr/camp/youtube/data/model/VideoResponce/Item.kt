package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("contentDetails")
    val contentDetails: ContentDetailsResponse,
    @SerializedName("etag")
    val etag: String,
    @SerializedName("fileDetails")
    val fileDetails: FileDetailsResponse,
    @SerializedName("id")
    val id: String,
    @SerializedName("kind")
    val kind: String,
    @SerializedName("liveStreamingDetails")
    val liveStreamingDetails: LiveStreamingDetailsResponse,
    @SerializedName("localizations")
    val localizations: LocalizationsResponse,
    @SerializedName("player")
    val player: PlayerResponse,
    @SerializedName("processingDetails")
    val processingDetails: ProcessingDetailsResponse,
    @SerializedName("recordingDetails")
    val recordingDetails: RecordingDetailsResponse,
    @SerializedName("snippet")
    val snippet: SnippetResponse,
    @SerializedName("statistics")
    val statistics: StatisticsResponse,
    @SerializedName("status")
    val status: StatusResponse,
    @SerializedName("suggestions")
    val suggestions: SuggestionsResponse,
    @SerializedName("topicDetails")
    val topicDetails: TopicDetailsResponse
)