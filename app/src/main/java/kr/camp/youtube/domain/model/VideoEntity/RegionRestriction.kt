package kr.camp.youtube.data.model.VideoEntity


import com.google.gson.annotations.SerializedName

data class RegionRestrictionEntity(
    val allowed: List<String>,
    val blocked: List<String>
)