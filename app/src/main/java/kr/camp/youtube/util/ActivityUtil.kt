package kr.camp.youtube.util

import android.content.Context
import android.content.Intent
import kr.camp.youtube.view.detail.VideoDetailActivity
import kr.camp.youtube.view.intent.IntentKey
import kr.camp.youtube.view.intent.item.DetailItem

object ActivityUtil {

    fun startVideoDetailActivity(context: Context, detailItem: DetailItem) {
        val intent = Intent(context, VideoDetailActivity::class.java)
        intent.putExtra(IntentKey.DETAIL_ITEM, detailItem)
        context.startActivity(intent)
    }
}