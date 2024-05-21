package kr.camp.youtube.domain.model.VideoEntity

data class ItemEntity(
    val etag: String?,
    val id: String?,
    val kind: String?,
    val snippet: SnippetEntity
)