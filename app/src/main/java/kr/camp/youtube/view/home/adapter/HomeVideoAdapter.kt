package kr.camp.youtube.view.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ItemCategoryVideoBinding
import kr.camp.youtube.view.home.state.HomeVideoItem

class HomeVideoAdapter(
    private val onItemClick: (HomeVideoItem) -> Unit = {}
) : RecyclerView.Adapter<HomeVideoAdapter.HomeVideoItemViewHolder>() {

    private val homeVideolList = mutableListOf<HomeVideoItem>()

    class HomeVideoItemViewHolder(
        var binding: ItemCategoryVideoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val glide = Glide.with(binding.root)
        fun bind(homeVideoItemPosition: HomeVideoItem) = with(binding) {
            glide.load(homeVideoItemPosition.thumbnailUrl).into(thumbnailImageView)
            videoTitleTextView.text = homeVideoItemPosition.videoTitle
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVideoItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryVideoBinding.inflate(layoutInflater, parent, false)
        return HomeVideoItemViewHolder(binding)
    }

    override fun getItemCount(): Int = homeVideolList.size

    override fun onBindViewHolder(holder: HomeVideoItemViewHolder, position: Int) {
        val itemPosition = homeVideolList[position]
        holder.apply {
            bind(itemPosition)
            binding.root.setOnClickListener {
                onItemClick(itemPosition)
            }

        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun update(newHomeVideoList: List<HomeVideoItem>) {
        this.homeVideolList.clear()
        this.homeVideolList.addAll(newHomeVideoList)
        notifyDataSetChanged()
    }
}
