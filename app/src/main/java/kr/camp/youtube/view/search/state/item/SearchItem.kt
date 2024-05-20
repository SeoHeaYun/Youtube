package kr.camp.youtube.view.search.state.item

sealed interface SearchItem {

    data class ImageItem(
        val thumbnailUrl: String,
        val videoTitle: String,
        val channelName: String
    ) : SearchItem

    data object LoadingItem : SearchItem
}