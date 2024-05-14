package kr.camp.youtube.view.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ItemSearchBinding
import kr.camp.youtube.view.search.state.item.SearchListItem

class SearchAdpater(
    private val onItemClick: (SearchListItem) -> Unit = {}
) : RecyclerView.Adapter<SearchAdpater.SearchViewHolder>() {

    inner class SearchViewHolder(
        private val binding: ItemSearchBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val glide = Glide.with(binding.root)

        init {
            binding.root.setOnClickListener {
                val searchListItem = searchListItems[adapterPosition]
                onItemClick(searchListItem)
            }
        }

        fun bind(searchListItem: SearchListItem) = with(binding) {
            glide.load(searchListItem.thumbnailUrl).into(thumbnailImageView)
            videoTitleTextView.text = searchListItem.videoTitle
            channelNameTextView.text = searchListItem.channelName
        }
    }

    private val searchListItems = mutableListOf<SearchListItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSearchBinding.inflate(layoutInflater, parent, false)
        return SearchViewHolder(binding)
    }

    override fun getItemCount(): Int = searchListItems.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val item = searchListItems[position]
        holder.bind(item)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(searchListItems: List<SearchListItem>) {
        this.searchListItems.clear()
        this.searchListItems.addAll(searchListItems)
        notifyDataSetChanged()
    }
}