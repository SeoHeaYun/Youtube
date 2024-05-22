package kr.camp.youtube.view.home.state

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


sealed interface HomeItem {

    val thumbnailUrl: String
    val description: String

    @Parcelize
    data class CategoryPopularItem(
        override val thumbnailUrl: String,
        override val description: String,
        val videoTitle: String,
        val channelTitle: String
    ) : HomeItem, Parcelable

    @Parcelize
    data class MostPopularItem(
        override val thumbnailUrl: String,
        override val description: String,
        val videoTitle: String,
        val channelTitle: String
    ) : HomeItem, Parcelable


}