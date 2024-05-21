package kr.camp.youtube.view.home.UserItem

sealed interface HomeItem {

    val thumbnailUrl: String



    // HomeChannelAdapter
    data class ChannelItem(
        override val thumbnailUrl: String,
        val channelName: String
    ) : HomeItem

    // HomeVideoAdapter
    data class VideoItem(
        override val thumbnailUrl: String,
        val videoTitle: String
    ) : HomeItem

    // HomePopularAdapter
    data class PopularItem(
        override val thumbnailUrl: String,
        val videoTitle: String
    ) : HomeItem


}