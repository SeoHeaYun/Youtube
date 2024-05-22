package kr.camp.youtube.data.model.video


import com.google.gson.annotations.SerializedName

data class PageInfoResponce(
    @SerializedName("resultsPerPage")
    val resultsPerPage: Int?,
    @SerializedName("totalResults")
    val totalResults: Int?
)