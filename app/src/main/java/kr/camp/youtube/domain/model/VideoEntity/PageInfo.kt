package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class PageInfoEntity(
    val resultsPerPage: Int,
    val totalResults: Int
)