package kr.camp.youtube.view.myVideo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.data.model.ItemResponse
import kr.camp.youtube.databinding.ItemMyVideoBinding
import kr.camp.youtube.view.detail.VideoDetailActivity


class MyVideoAdapter(private val videoList: List<ItemResponse>) :
    RecyclerView.Adapter<MyVideoAdapter.VideoViewHolder>() {
    class VideoViewHolder(val binding: ItemMyVideoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemMyVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videoList[position]
        val thumbnailUrl = video.snippet.thumbnails.high.url
        val title = video.snippet.title
        val channeltitle = video.snippet.channelTitle

        //썸네일 이미지 로딩
        Glide.with(holder.binding.imageViewThumbnail.context)
            .load(thumbnailUrl)
            .into(holder.binding.imageViewThumbnail)

        //텍스트뷰 로딩
        holder.binding.textViewTitle.text = title
        holder.binding.textViewTitle.text = channeltitle

        //디테일 엑티비티
        holder.binding.root.setOnClickListener{
            val context = holder.binding.root.context
            val intent = Intent(context, VideoDetailActivity::class.java).apply {
                putExtra("VIDEO_TITLE",video.snippet.title)
                putExtra("VIDEO_DESCRIPTION", video.snippet.description)
            }

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }
}