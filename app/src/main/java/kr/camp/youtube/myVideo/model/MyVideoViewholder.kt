package kr.camp.youtube.myVideo.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ItemMyVideoBinding
import kr.camp.youtube.myVideo.adaptder.MyVideoItem

class MyVideoViewholder(private val binding: ItemMyVideoBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(videoItem: MyVideoItem) {
        binding.textViewTitle.text = videoItem.title
        Glide.with(binding.root.context).load(videoItem.thumbnailUrl).into(binding.imageViewThumbnail)

        binding.root.setOnClickListener{
            //디테일프레그먼트 연결
        }
    }

    companion object {
        fun from(parent: ViewGroup): MyVideoViewholder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemMyVideoBinding.inflate(layoutInflater, parent, false)
            return MyVideoViewholder(binding)
        }
    }
}