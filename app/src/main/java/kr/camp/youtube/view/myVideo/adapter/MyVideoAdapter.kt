package kr.camp.youtube.view.myVideo.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ItemMyVideoBinding
import kr.camp.youtube.view.detail.VideoDetailActivity
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.myVideo.state.MyVideoFragment

class MyVideoAdapter(var items: MutableList<LikeItemModel>) :
    RecyclerView.Adapter<MyVideoAdapter.VideoViewHolder>() {

    private var likedItems: List<LikeItemModel> = items.filter { it.isLike }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemMyVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val item = likedItems[position]

        //텍스트뷰 로딩
        holder.textView_title.text = item.title
        holder.textView_channelTitle.text = item.channelTitle

        //썸네일 이미지 로딩
        Glide.with(holder.imageView_thumbnail.context)
            .load(item.url)
            .into(holder.binding.imageViewThumbnail)


        //디테일 엑티비티
        holder.binding.root.setOnClickListener {
            val context = holder.binding.root.context
            val intent = Intent(context, VideoDetailActivity::class.java)
            intent.putExtra("item", item)
            (context as Activity).startActivityForResult(intent, MyVideoFragment.VIDEO_DETAIL_REQUEST_CODE)
        }

    }

    override fun getItemCount(): Int {
        return likedItems.size
    }

    fun updateItems(newItems: List<LikeItemModel>){
        items = newItems.toMutableList()
        likedItems = items.filter { it.isLike }
        notifyDataSetChanged()
    }

    //뷰홀더
    inner class VideoViewHolder(val binding: ItemMyVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var imageView_thumbnail = binding.imageViewThumbnail
        var textView_title = binding.textViewTitle
        var textView_channelTitle = binding.textViewVideoId
        var constraintLayout = binding.contraintlayout

        init {
            //아이템 클릭리스너 설정
            constraintLayout.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    items.removeAt(position)
                    likedItems = items.filter { it.isLike }
                    notifyItemRemoved(position)
                }
            }
        }
    }
}
