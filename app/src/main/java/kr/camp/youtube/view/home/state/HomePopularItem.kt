package kr.camp.youtube.view.home.state

sealed interface HomePopularItem {
    val thumbnailUrl: String
    val videoTitle: String

    data class ImageItem(
        override val thumbnailUrl: String,
        override val videoTitle: String,
    ) : HomePopularItem
}