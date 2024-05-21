package kr.camp.youtube.view.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ItemMostpopularVideoBinding
import kr.camp.youtube.view.home.state.HomeItem

class HomeMostPopularAdapter(
    private val onItemClick: (HomeItem.mostPopularItem) -> Unit = {}
) : RecyclerView.Adapter<HomeMostPopularAdapter.MostPopularItemViewHolder>() {

    private val homePopularlList = mutableListOf<HomeItem.mostPopularItem>()

    class MostPopularItemViewHolder(
        var binding: ItemMostpopularVideoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val glide = Glide.with(binding.root)
        fun bind(homePopularItemPosition: HomeItem.mostPopularItem) = with(binding) {
            glide.load(homePopularItemPosition.thumbnailUrl).into(thumbnailImageView)
            videoTitleTextView.text = homePopularItemPosition.videoTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostPopularItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMostpopularVideoBinding.inflate(layoutInflater, parent, false)
        return MostPopularItemViewHolder(binding)
    }

    override fun getItemCount(): Int = homePopularlList.size

    override fun onBindViewHolder(holder: MostPopularItemViewHolder, position: Int) {
        val itemPosition = homePopularlList[position]
        holder.apply {
            bind(itemPosition)
            binding.root.setOnClickListener {
                onItemClick(itemPosition)
            }

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateItem(newHomePopularList: List<HomeItem.mostPopularItem>) {
        this.homePopularlList.clear()
        this.homePopularlList.addAll(newHomePopularList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        updateItem(emptyList())
    }
}

