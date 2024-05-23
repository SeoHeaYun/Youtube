package kr.camp.youtube.view.myvideo.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ItemMyVideoBinding
import kr.camp.youtube.extension.toSpanned
import kr.camp.youtube.view.detail.VideoDetailActivity
import kr.camp.youtube.view.key.IntentKey
import kr.camp.youtube.view.key.item.DetailItem
import kr.camp.youtube.view.myvideo.state.MyVideoFragment
import kr.camp.youtube.view.registry.DetailItemRegistry

class MyVideoAdapter : RecyclerView.Adapter<MyVideoAdapter.VideoViewHolder>() {

    private var items = listOf<DetailItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemMyVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val item = items[position]

        //텍스트뷰 로딩
        holder.textView_title.text = item.videoTitle.toSpanned()
        holder.textView_channelTitle.text = item.channelName.toSpanned()

        //썸네일 이미지 로딩
        Glide.with(holder.imageView_thumbnail.context)
            .load(item.thumbnailUrl)
            .into(holder.binding.imageViewThumbnail)

        //디테일 엑티비티
        holder.binding.root.setOnClickListener {
            val context = it.context
            val intent = Intent(context, VideoDetailActivity::class.java)
            intent.putExtra(IntentKey.DETAIL_ITEM, item)
            (context as Activity).startActivityForResult(intent, MyVideoFragment.VIDEO_DETAIL_REQUEST_CODE)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(){
        this.items = DetailItemRegistry.likes.toMutableList()
        notifyDataSetChanged()
    }

    //뷰홀더
    inner class VideoViewHolder(val binding: ItemMyVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var imageView_thumbnail = binding.imageViewThumbnail
        var textView_title = binding.textViewTitle
        var textView_channelTitle = binding.textViewChannelName
        var constraintLayout = binding.contraintlayout

        init {
            //아이템 클릭리스너 설정
            constraintLayout.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    items = items.toMutableList().apply { removeAt(position) }
                }
            }
        }
    }
}
