package kr.camp.youtube.view.myvideo.adapter

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.camp.youtube.view.detail.model.DummyDataManager
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.detail.model.SharedPreferencesManager

class MyVideoViewModel(application: Application) : AndroidViewModel(application) {
    private val _likedItems = MutableLiveData<List<LikeItemModel>>()
    val likedItems: LiveData<List<LikeItemModel>> get() = _likedItems

    init {
        val dummyData = listOf(
            LikeItemModel(
                "고양이가 나오는 영상",
                "고양이채널",
                "https://i.ytimg.com/vi/aip80BfeuDg/hqdefault.jpg",
                "고양이가 나오는 영상입니당",
                true
            ),
            LikeItemModel(
                "강아지가 나오는 영상",
                "강아지채널",
                "https://i.ytimg.com/vi/BR7OFcEFRDw/hqdefault.jpg",
                "강아지가 나오는 영상입니당",
                true
            ),
            LikeItemModel(
                "조랑말이 나오는 동영상",
                "조랑말",
                "https://i.ytimg.com/vi/FRqjPXL5i0M/hqdefault.jpg",
                "조랑말이 나오는 영상입니당",
                true
            )
        )
        _likedItems.value = dummyData

    }

    fun updateLikedItems() {
        // 실제 좋아요 데이터를 SharedPreferences에서 불러오는 로직을 추가
        val context = getApplication<Application>().applicationContext
        val likedTitles = SharedPreferencesManager.getLikedItems(context)
        val allItems = DummyDataManager.getDummyData(context)
        _likedItems.value = allItems.filter { likedTitles.contains(it.videoTitle) }
    }

}