package kr.camp.youtube.data.model.ChannelsEntity


import com.google.gson.annotations.SerializedName

data class PageInfoEntity(
    val resultsPerPage: Int,
    val totalResults: Int
)