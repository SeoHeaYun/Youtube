package kr.camp.youtube.data.model.ChannelsEntity


import com.google.gson.annotations.SerializedName
import kr.camp.youtube.data.model.ChannelsResponce.ChannelEntity


data class BrandingSettingsEntity(
    val channel: ChannelEntity,
    val watch: WatchEntity
)