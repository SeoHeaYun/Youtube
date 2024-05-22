package kr.camp.youtube.domain.model.VideoEntity

data class ThumbnailsEntity(
    val default: DefaultEntity,
    val high: HighEntity,
    val maxres: MaxresEntity?,
    val medium: MediumEntity?,
    val standard: StandardEntity?
)