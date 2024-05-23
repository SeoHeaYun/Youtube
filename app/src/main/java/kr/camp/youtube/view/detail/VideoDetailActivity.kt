package kr.camp.youtube.view.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import kr.camp.youtube.R
import kr.camp.youtube.databinding.ActivityVideoDetailBinding
import kr.camp.youtube.extension.toSpanned
import kr.camp.youtube.view.intent.IntentKey
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.detail.model.SharedPreferencesManager
import kr.camp.youtube.view.intent.item.DetailItem
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class VideoDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityVideoDetailBinding.inflate(layoutInflater) }
    private lateinit var item: LikeItemModel
    // 좋아요를 눌러 선택된 아이템을 저장하는 리스트
    private var likedItems: ArrayList<LikeItemModel> = ArrayList()
    private var stringPrefs : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        overridePendingTransition(R.anim.from_down_enter, R.anim.none)
        setupView()

        getPrefLikeItems("likeditems")
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
        likeButton.text = if (item.isLike) "Like" else "UnLike"

        likeButton.setOnClickListener{
            if (!item.isLike) {
                addPrefItem("likeditems", likedItems)
                item.isLike = true
                likeButton.text = "LIKE"
                Log.d("TAG", likedItems.toString())
            } else {
                deletePrefItem(item.thumbnailUrl)
                item.isLike = false
                likeButton.text = "UNLIKE"
                Log.d("TAG2", likedItems.toString())
            }
        }


        buttonBack.setOnClickListener{
            val resultIntent = Intent().apply {
                putExtra(IntentKey.DETAIL_ITEM, item)
            }
            setResult(Activity.RESULT_OK, resultIntent)

            super.finish()
            overridePendingTransition(R.anim.none, R.anim.to_down_exit)
        }
    }

    fun addPrefItem(key: String, items: ArrayList<LikeItemModel>) {
        val sharedPreferences = getSharedPreferences("shared preferences", Context.MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        val jsonArray = JSONArray()
        val gson = GsonBuilder().create()

        for (i in 0 until items.size) {
            val string = gson.toJson(items.get(i), LikeItemModel::class.java)
            jsonArray.put(string)
            Log.d("TAG3", string)
        }

        if (!items.isEmpty()) {
            edit.putString(key, gson.toJson(item.thumbnailUrl))
        } else {
            edit.putString(key, null)
        }

        edit.apply()
    }

    fun deletePrefItem(thumbnailUrl: String) {
        val sharedPreferences = getSharedPreferences("shared preferences", Context.MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        edit.remove(thumbnailUrl)
        edit.apply()
    }
}
