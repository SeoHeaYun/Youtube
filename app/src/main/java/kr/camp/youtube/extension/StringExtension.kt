package kr.camp.youtube.extension

import android.text.Spanned
import androidx.core.text.HtmlCompat

fun String.toSpanned(): Spanned {
    return HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY)
}