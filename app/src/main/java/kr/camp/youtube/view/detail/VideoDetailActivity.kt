package kr.camp.youtube.view.detail

import android.content.ClipData
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kr.camp.youtube.databinding.ActivityVideoDetailBinding
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.detail.model.OnLikeActionListner
import okhttp3.internal.notify

class VideoDetailActivity : AppCompatActivity(), OnLikeActionListner {
    private val binding by lazy { ActivityVideoDetailBinding.inflate(layoutInflater) }
    private var items: MutableList<LikeItemModel> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.likeButton.setOnClickListener() {
            val items = mutableListOf<ClipData.Item>()
            val position = 0

        }
    }

    override fun onLike(item: LikeItemModel) {
        likedItems.add(item)
    }
    override fun onUnlike(item: LikeItemModel){
        likedItems.remove(item)
    }

    // 좋아요를 눌러 선택된 아이템을 저장하는 리스트
    var likedItems: ArrayList<LikeItemModel> = ArrayList()

    /**
     * 좋아요가 눌린 아이템을 likedItems 리스트에 추가하는 함수입니다.
     * @param item 좋아요가 눌린 아이템
     */
    fun addLikedItem(item: LikeItemModel) {
        if(!likedItems.contains(item)) {
            likedItems.add(item)
        }
    }
    /**
     * 좋아요가 취소된 아이템을 likedItems 리스트에서 제거하는 함수입니다.
     * @param item 좋아요가 취소된 아이템
     */
    fun removeLikedItem(item: LikeItemModel) {
        likedItems.remove(item)
    }


}

