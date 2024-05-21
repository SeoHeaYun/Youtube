package kr.camp.youtube.data.model.VideoCategoriesresponse


import com.google.gson.annotations.SerializedName

data class PageInfoResponse(
    @SerializedName("resultsPerPage")
    val resultsPerPage: String,
    @SerializedName("totalResults")
    val totalResults: String
)