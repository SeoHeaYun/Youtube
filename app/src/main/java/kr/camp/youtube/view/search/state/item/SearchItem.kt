package kr.camp.youtube.view.search.state.item

import kotlinx.parcelize.Parcelize
import kr.camp.youtube.view.key.item.DetailItem

sealed interface SearchItem {

    @Parcelize
    data class ImageItem(
        override val thumbnailUrl: String,
        override val videoTitle: String,
        override val videoDescription: String,
        override val channelName: String
    ) : SearchItem, DetailItem

    data object LoadingItem : SearchItem
}