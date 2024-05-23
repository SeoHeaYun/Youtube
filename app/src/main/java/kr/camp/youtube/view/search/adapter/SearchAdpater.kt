package kr.camp.youtube.view.search.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.camp.youtube.databinding.ItemSearchResultBinding
import kr.camp.youtube.databinding.ItemSearchLoadingBinding
import kr.camp.youtube.extension.toSpanned
import kr.camp.youtube.view.search.adapter.enums.SearchViewType
import kr.camp.youtube.view.search.state.item.SearchItem

class SearchAdpater(
    private val onItemClick: (SearchItem) -> Unit = {}
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class SearchResultViewHolder(
        private val binding: ItemSearchResultBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val glide = Glide.with(binding.root)

        init {
            binding.root.setOnClickListener {
                val searchListItem = searchItems[adapterPosition]
                onItemClick(searchListItem)
            }
        }

        fun bind(searchItem: SearchItem.ImageItem) = with(binding) {
            glide.load(searchItem.thumbnailUrl).into(thumbnailImageView)
            videoTitleTextView.text = searchItem.videoTitle.toSpanned()
            channelNameTextView.text = searchItem.channelName
        }
    }

    inner class SearchLoadingViewHolder(
        binding: ItemSearchLoadingBinding
    ) : RecyclerView.ViewHolder(binding.root)

    private val searchItems = mutableListOf<SearchItem>()

    override fun getItemViewType(position: Int): Int {
        return SearchViewType.findViewTypeOrdinalBySearchItem(searchItems[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, ordinal: Int): RecyclerView.ViewHolder {
        val searchViewType = SearchViewType.findViewTypeByOrdinal(ordinal) ?: throw NullPointerException()
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (searchViewType) {
            SearchViewType.SEARCH_RESULT -> {
                val binding = ItemSearchResultBinding.inflate(layoutInflater, parent, false)
                SearchResultViewHolder(binding)
            }
            SearchViewType.SEARCH_LOADING -> {
                val binding = ItemSearchLoadingBinding.inflate(layoutInflater, parent, false)
                SearchLoadingViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = searchItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SearchResultViewHolder) {
            val item = searchItems[position]
            if (item is SearchItem.ImageItem) {
                holder.bind(item)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(searchItems: List<SearchItem>, hasNextPage: Boolean) {
        applyItems(searchItems, hasNextPage, true)
        notifyDataSetChanged()
    }

    fun addItems(searchItems: List<SearchItem>, hasNextPage: Boolean) {
        applyItems(searchItems, hasNextPage, false)
        val totalSearchItemsSize = this.searchItems.size
        notifyItemRangeChanged(totalSearchItemsSize - searchItems.size, totalSearchItemsSize)
    }

    fun clearItems() {
        setItems(emptyList(), false)
    }

    private fun applyItems(searchItems: List<SearchItem>, hasNextPage: Boolean, clear: Boolean) {
        this.searchItems.apply {
            if (clear) {
                clear()
            }
            if (searchItems.isNotEmpty()) {
                addAll(searchItems)
            }
            if (hasNextPage) {
                add(SearchItem.LoadingItem)
            }
        }
    }

    fun removeLoading() {
        searchItems.removeLastOrNull()
    }
}