package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class ContentDetailsEntity(
    val caption: String,
    val contentRating: ContentRatingEntity,
    val definition: String,
    val dimension: String,
    val duration: String,
    val hasCustomThumbnail: Boolean,
    val licensedContent: Boolean,
    val projection: String,
    val regionRestriction: RegionRestrictionEntity
)