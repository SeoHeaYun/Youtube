package kr.camp.youtube.data.model.VideoCategoriesEntity


import com.google.gson.annotations.SerializedName

data class ItemEntity(
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: SnippetEntity
)