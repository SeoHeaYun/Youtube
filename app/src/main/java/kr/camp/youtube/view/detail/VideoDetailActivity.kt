package kr.camp.youtube.view.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kr.camp.youtube.R
import kr.camp.youtube.databinding.ActivityVideoDetailBinding
import kr.camp.youtube.extension.toSpanned
import kr.camp.youtube.view.intent.IntentKey
import kr.camp.youtube.view.detail.model.DummyDataManager
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.intent.item.DetailItem


class VideoDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityVideoDetailBinding.inflate(layoutInflater) }
    private lateinit var item: LikeItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        overridePendingTransition(R.anim.from_down_enter, R.anim.none)
//        item = intent.getSerializableExtra("item") as LikeItemModel

        setupView()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.none, R.anim.to_down_exit)
        val resultIntent = Intent().apply {
            putExtra(IntentKey.DETAIL_ITEM, item)
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    private fun setupView() = with(binding) {
        val detailItem = intent.getParcelableExtra(IntentKey.DETAIL_ITEM) as? DetailItem
            ?: throw NullPointerException()

        item = LikeItemModel(
            detailItem.videoTitle,
            detailItem.channelName,
            detailItem.thumbnailUrl,
            detailItem.videoDescription,
            if (detailItem is LikeItemModel) detailItem.isLike else false
        )

        Glide.with(this@VideoDetailActivity)
            .load(detailItem.thumbnailUrl)
            .into(binding.videoImageView)

        titleTextView.text = detailItem.videoTitle.toSpanned()
        descriptionTextView.text = detailItem.videoDescription.toSpanned()
        likeButton.text = if (item.isLike) "UnLike" else "Like"

        likeButton.setOnClickListener{
            item.changeLike()
            binding.likeButton.text = if (item.isLike) "UnLike" else "Like"
            updateDummyData()
        }

        buttonBack.setOnClickListener{
            val resultIntent = Intent().apply {
                putExtra(IntentKey.DETAIL_ITEM, item)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun updateDummyData(){
        val dummyData = DummyDataManager.getDummyData().toMutableList()
        val index = dummyData.indexOfFirst { it.videoTitle == item.videoTitle }
        if (index != -1) {
            dummyData[index] = item
            DummyDataManager.updateDummyData(dummyData)
        }
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



