package kr.camp.youtube.domain.model.video

data class ItemEntity(
    val etag: String?,
    val id: String?,
    val kind: String?,
    val snippet: SnippetEntity
)