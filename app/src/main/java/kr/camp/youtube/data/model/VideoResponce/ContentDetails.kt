package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class ContentDetailsResponse(
    @SerializedName("caption")
    val caption: String,
    @SerializedName("contentRating")
    val contentRating: ContentRatingResponse,
    @SerializedName("definition")
    val definition: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("hasCustomThumbnail")
    val hasCustomThumbnail: Boolean,
    @SerializedName("licensedContent")
    val licensedContent: Boolean,
    @SerializedName("projection")
    val projection: String,
    @SerializedName("regionRestriction")
    val regionRestriction: RegionRestrictionResponse
)