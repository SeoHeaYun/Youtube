package kr.camp.youtube.view.home.state

sealed  interface HomeChannelItem {

    val thumbnailUrl: String

    val channelName: String

    data class ImageItem(
        override val thumbnailUrl: String,
        override val channelName: String
    ) : HomeChannelItem
}