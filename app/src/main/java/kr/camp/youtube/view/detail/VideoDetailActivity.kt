package kr.camp.youtube.view.detail

import android.content.ClipData
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ActivityVideoDetailBinding
import kr.camp.youtube.view.home.state.HomeItem
import kr.camp.youtube.view.search.state.item.SearchItem
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.detail.model.OnLikeActionListner

class VideoDetailActivity : AppCompatActivity(), OnLikeActionListner {
    private val binding by lazy { ActivityVideoDetailBinding.inflate(layoutInflater) }

    private val getHomeDataList = mutableListOf<HomeItem>()
    private val getSearchDataList = mutableListOf<SearchItem>()

    fun receiveHomeDataList(item: HomeItem) {
        getHomeDataList.add(item)
    }

    fun receiveSearchDataList(item: SearchItem) {
        getSearchDataList.add(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()

    }

    private fun setupView() {
        val Id = intent.getStringExtra("ID")
        val videoTitle = intent.getStringExtra("VIDEO_TITLE")
        val videoDescription = intent.getStringExtra("VIDEO_DESCRIPTION")
        Glide.with(this)
            .load("https://www.youtube.com/embed/${Id}")
            .into(binding.videoImageView)
        binding.titleTextView.setText(videoTitle)
        binding.descriptionTextView.setText(videoDescription)
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

