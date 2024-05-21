package kr.camp.youtube.data.model.VideoResponse


import com.google.gson.annotations.SerializedName

data class RegionRestrictionResponse(
    @SerializedName("allowed")
    val allowed: List<String>,
    @SerializedName("blocked")
    val blocked: List<String>
)