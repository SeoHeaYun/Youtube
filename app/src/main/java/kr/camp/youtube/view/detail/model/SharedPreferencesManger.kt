package kr.camp.youtube.view.detail.model

import android.content.Context
import android.content.SharedPreferences

object SharedPreferencesManager {

    private const val PREFS_NAME = "like_prefs"
    private const val KEY_LIKED_ITEMS = "liked_items"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun isLiked(context: Context, videoTitle: String): Boolean {
        val prefs = getPreferences(context)
        return prefs.getBoolean(videoTitle, false)
    }

    fun setLiked(context: Context, videoTitle: String, isLiked: Boolean) {
        val prefs = getPreferences(context)
        with(prefs.edit()) {
            putBoolean(videoTitle, isLiked)
            apply()
        }
    }

    fun getLikedItems(context: Context): List<String> {
        val prefs = getPreferences(context)
        return prefs.all.filterValues { it == true }.keys.toList()
    }
}