package kr.camp.youtube.view.intent.item

import android.os.Parcelable

interface DetailItem : Parcelable {

    val thumbnailUrl: String

    val videoTitle: String

    val videoDescription: String

    val channelName: String
}