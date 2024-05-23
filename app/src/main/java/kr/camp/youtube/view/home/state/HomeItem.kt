package kr.camp.youtube.view.home.state

import kotlinx.parcelize.Parcelize
import kr.camp.youtube.view.intent.item.DetailItem

sealed interface HomeItem {

    @Parcelize
    data class CategoryPopularItem(
        override val thumbnailUrl: String,
        override val videoTitle: String,
        override val videoDescription: String,
        override val channelName: String
    ) : HomeItem, DetailItem

    @Parcelize
    data class MostPopularItem(
        override val thumbnailUrl: String,
        override val videoTitle: String,
        override val videoDescription: String,
        override val channelName: String
    ) : HomeItem, DetailItem


}