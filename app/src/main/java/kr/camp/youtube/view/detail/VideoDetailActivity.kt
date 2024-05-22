package kr.camp.youtube.view.detail

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.gson.GsonBuilder
import kr.camp.youtube.data.model.ItemResponse
import kr.camp.youtube.databinding.ActivityVideoDetailBinding
import kr.camp.youtube.view.home.state.HomeItem
import kr.camp.youtube.view.search.state.item.SearchItem

class VideoDetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityVideoDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val likeList : ArrayList<ItemResponse> // Id

        setupView()

        binding.likeButton.setOnClickListener {
        }
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

    fun addPrefItem(item: ItemResponse) {
        val sharedPreferences = getSharedPreferences("shared preferences", Activity.MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        val gson = GsonBuilder().create()
        edit.putString(item.id.toString(), gson.toJson(item))
//        edit.putString(item.id?.videoId, gson.toJson(item))
        edit.apply()
    }

    fun deletePrefItem(id: String) {
        val sharedPreferences = getSharedPreferences("shared preferences", Activity.MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        edit.remove(id)
        edit.apply()
    }
    fun getPrefItem(): ArrayList<ItemResponse> {
        val sharedPreferences = getSharedPreferences("shared preferences", Activity.MODE_PRIVATE)
        val allEntries: Map<String, *> = sharedPreferences.all
        val likeList = ArrayList<ItemResponse>()
        val gson = GsonBuilder().create()
        for ((key, value) in allEntries) {
            val item = gson.fromJson(value as String, ItemResponse::class.java)
            likeList.add(item)
        }
        return likeList
    }
}