package kr.camp.youtube.myVideo.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.camp.youtube.domain.model.SearchEntity
import kr.camp.youtube.myVideo.adaptder.MyVideoItem
import kr.camp.youtube.myVideo.model.MyVideoViewholder

class MyVideoAdapter(private val videoList: List<MyVideoItem>) :
    RecyclerView.Adapter<MyVideoViewholder>() {

    lateinit var itemClick: ItemClick
    private var likedVideos: MutableList<SearchEntity> = mutableListOf()

    interface ItemClick {
        fun onClick()
        //디테일프래그먼트 연결
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVideoViewholder {
        return MyVideoViewholder.from(parent)
    }

    override fun onBindViewHolder(holder: MyVideoViewholder, position: Int) {
        holder.bind(videoList[position])
    }

    override fun getItemCount(): Int {
        return videoList.size
    }
}