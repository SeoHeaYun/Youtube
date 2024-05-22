package kr.camp.youtube.view.detail

import android.content.ClipData
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ActivityVideoDetailBinding
import kr.camp.youtube.view.detail.model.LikeItemModel


class VideoDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityVideoDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupView()

        binding.buttonBack.setOnClickListener{
            onBackPressed()
        }

    }

    private fun setupView() {
        val item = intent.getSerializableExtra("item") as LikeItemModel

        Glide.with(this)
            .load(item.url)
            .into(binding.videoImageView)

        binding.titleTextView.text = item.title
        binding.descriptionTextView.text = item.desc

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

