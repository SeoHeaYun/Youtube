package kr.camp.youtube.view.home.state

import kr.camp.youtube.view.search.state.item.SearchListItem

sealed  interface HomeChannelItem {

    val thumbnailUrl: String

    val channelName: String

    data class ImageItem(
        override val thumbnailUrl: String,
        override val channelName: String
    ) : HomeChannelItem
}