package kr.camp.youtube.view.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ItemCategorypopularVideoBinding
import kr.camp.youtube.view.home.state.HomeItem
import kr.camp.youtube.view.search.state.item.SearchItem

class HomeCategoryPopularAdapter(
    private val onItemClick: (HomeItem.categoryPopularItem) -> Unit = {}
) : RecyclerView.Adapter<HomeCategoryPopularAdapter.CategoryPopularItemViewHolder>() {

    private val homeVideolList = mutableListOf<HomeItem.categoryPopularItem>()

    class CategoryPopularItemViewHolder(
        var binding: ItemCategorypopularVideoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val glide = Glide.with(binding.root)
        fun bind(homeVideoItemPosition: HomeItem.categoryPopularItem) = with(binding) {
            glide.load(homeVideoItemPosition.thumbnailUrl).into(thumbnailImageView)
            videoNameTextView.text = homeVideoItemPosition.videoTitle
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryPopularItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategorypopularVideoBinding.inflate(layoutInflater, parent, false)
        return CategoryPopularItemViewHolder(binding)
    }

    override fun getItemCount(): Int = homeVideolList.size

    override fun onBindViewHolder(holder: CategoryPopularItemViewHolder, position: Int) {
        val itemPosition = homeVideolList[position]
        holder.apply {
            bind(itemPosition)
            binding.root.setOnClickListener {
                onItemClick(itemPosition)
            }

        }
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateItem(newHomeVideoList: List<HomeItem.categoryPopularItem>) {
        this.homeVideolList.clear()
        this.homeVideolList.addAll(newHomeVideoList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        updateItem(emptyList())
    }
}
