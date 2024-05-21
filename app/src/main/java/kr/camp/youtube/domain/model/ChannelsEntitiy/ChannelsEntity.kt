package kr.camp.youtube.data.model.ChannelsResponce


import com.google.gson.annotations.SerializedName
import kr.camp.youtube.data.model.ChannelsEntity.ItemEntity
import kr.camp.youtube.data.model.ChannelsEntity.PageInfoEntity

data class ChannelsEntity(
    val etag: String,
    val items: List<ItemEntity>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfoEntity,
    val prevPageToken: String
)