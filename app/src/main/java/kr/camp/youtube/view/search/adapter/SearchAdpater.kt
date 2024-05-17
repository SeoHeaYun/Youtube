package kr.camp.youtube.view.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ItemSearchBinding
import kr.camp.youtube.extension.toSpanned
import kr.camp.youtube.view.search.state.item.SearchItem

class SearchAdpater(
    private val onItemClick: (SearchItem) -> Unit = {}
) : RecyclerView.Adapter<SearchAdpater.SearchViewHolder>() {

    inner class SearchViewHolder(
        private val binding: ItemSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val glide = Glide.with(binding.root)

        init {
            binding.root.setOnClickListener {
                val searchListItem = searchItems[adapterPosition]
                onItemClick(searchListItem)
            }
        }

        fun bind(searchItem: SearchItem) = with(binding) {
            glide.load(searchItem.thumbnailUrl).into(thumbnailImageView)
            videoTitleTextView.text = searchItem.videoTitle.toSpanned()
            channelNameTextView.text = searchItem.channelName
        }
    }

    private val searchItems = mutableListOf<SearchItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSearchBinding.inflate(layoutInflater, parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int = searchItems.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = searchItems[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(searchItems: List<SearchItem>) {
        this.searchItems.clear()
        this.searchItems.addAll(searchItems)
        notifyDataSetChanged()
    }
}