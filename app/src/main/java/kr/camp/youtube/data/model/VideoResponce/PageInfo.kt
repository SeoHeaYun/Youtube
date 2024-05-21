package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class PageInfoResponse(
    @SerializedName("resultsPerPage")
    val resultsPerPage: Int,
    @SerializedName("totalResults")
    val totalResults: Int
)