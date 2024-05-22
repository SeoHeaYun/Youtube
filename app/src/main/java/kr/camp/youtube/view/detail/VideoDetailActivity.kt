package kr.camp.youtube.view.detail

import android.app.Activity
import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ActivityVideoDetailBinding
import kr.camp.youtube.view.detail.model.DummyDataManager
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.Intent.IntentKey
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.detail.model.OnLikeActionListner
import kr.camp.youtube.view.home.state.HomeItem


class VideoDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityVideoDetailBinding.inflate(layoutInflater) }
    private lateinit var item: LikeItemModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        item = intent.getSerializableExtra("item") as LikeItemModel
        setupView()

        setupView()
    }



    private fun setupView() {

        val getCategoryItem: ArrayList<HomeItem.CategoryPopularItem>? = intent.getParcelableArrayListExtra(IntentKey.YUKTUBE)
        val getMostPopularItem: ArrayList<HomeItem.MostPopularItem>? = intent.getParcelableArrayListExtra(IntentKey.YUKTUBE)

        val Id = intent.getStringExtra("ID")
        val videoTitle = intent.getStringExtra("VIDEO_TITLE")
        val videoDescription = intent.getStringExtra("VIDEO_DESCRIPTION")
        Glide.with(this)
            .load(item.url)
            .into(binding.videoImageView)

        binding.titleTextView.text = item.title
        binding.descriptionTextView.text = item.desc

        binding.likeButton.text = if (item.isLike) "UnLike" else "Like"

        binding.likeButton.setOnClickListener{
            item.changeLike()
            binding.likeButton.text = if (item.isLike) "UnLike" else "Like"
            updateDummyData()
        }

        binding.buttonBack.setOnClickListener{
            val resultIntent = Intent().apply {
                putExtra("item", item)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }

    private fun updateDummyData(){
        val dummyData = DummyDataManager.getDummyData().toMutableList()
        val index = dummyData.indexOfFirst { it.title == item.title }
        if (index != -1) {
            dummyData[index] = item
            DummyDataManager.updateDummyData(dummyData)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val resultIntent = Intent().apply {
            putExtra("item", item)
        }
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
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



