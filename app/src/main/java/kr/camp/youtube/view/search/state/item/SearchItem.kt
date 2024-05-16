package kr.camp.youtube.view.search.state.item

sealed interface SearchItem {

    val thumbnailUrl: String

    val videoTitle: String

    val channelName: String

    data class ImageItem(
        override val thumbnailUrl: String,
        override val videoTitle: String,
        override val channelName: String
    ) : SearchItem
}