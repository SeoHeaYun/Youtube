package kr.camp.youtube.view.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.camp.youtube.R
import kr.camp.youtube.databinding.FragmentSearchBinding
import kr.camp.youtube.extension.addOnScrolled
import kr.camp.youtube.util.QueryUtil
import kr.camp.youtube.view.search.adapter.SearchAdpater
import kr.camp.youtube.view.search.model.SearchViewModel
import kr.camp.youtube.view.search.model.SearchViewModelFactory
import kr.camp.youtube.view.search.state.SearchUiState

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!

    private val searchViewModel: SearchViewModel by viewModels { SearchViewModelFactory() }

    private lateinit var searchAdapter: SearchAdpater

    private var currentSearchInput: String? = null
    private var nextPageToken: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerRecyclerView()
        registerViewModelEvent()
        registerSearchBar()
    }

    private fun registerRecyclerView() = with(binding.searchResultRecyclerView) {
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager
        adapter = SearchAdpater {}.apply {
            searchAdapter = this
        }
        itemAnimator = null
        addOnScrolled { _, _, _ ->
            val nextPageToken = nextPageToken
            val lastVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition()
            val itemTotalCount = searchAdapter.itemCount - 1
            if (nextPageToken != null &&
                itemTotalCount >= QueryUtil.RESULTS_PER_PAGE &&
                !canScrollVertically(1) &&
                lastVisibleItemPosition == itemTotalCount
            ) {
                val searchInput = currentSearchInput
                if (searchInput != null) {
                    searchAdapter.removeLoading()
                    searchViewModel.onSearch(searchInput, nextPageToken, false)
                }
            }
        }
    }

    private fun registerViewModelEvent() = with(binding) {
        viewLifecycleOwner.lifecycleScope.launch {
            searchViewModel.uiState.flowWithLifecycle(lifecycle).collectLatest { uiState ->
                val isLoading = uiState is SearchUiState.Loading
                searchBarEditText.isEnabled = !isLoading
                if (nextPageToken == null) {
                    searchProgressBar.isVisible = isLoading
                    searchResultRecyclerView.isVisible = uiState is SearchUiState.ResultSetList
                }
                searchResultNoticeTextView.isVisible = uiState is SearchUiState.Notice
                if (uiState is SearchUiState.ResultList) {
                    nextPageToken = uiState.nextPageToken
                }
                val hasNextPage = nextPageToken != null
                when (uiState) {
                    is SearchUiState.ResultEmpty -> searchAdapter.clearItems()
                    is SearchUiState.ResultSetList -> searchAdapter.setItems(uiState.items, hasNextPage)
                    is SearchUiState.ResultAddList -> searchAdapter.addItems(uiState.items, hasNextPage)
                    is SearchUiState.Notice -> searchResultNoticeTextView.text = uiState.message
                    else -> {}
                }
            }
        }
    }

    private fun registerSearchBar() = with(binding) {
        val search = {
            if (searchBarEditText.text.isBlank()) {
                Toast.makeText(context, getString(R.string.search_blank_error), Toast.LENGTH_SHORT).show()
            } else {
                hideKeyboard()
                searchBarEditText.clearFocus()

                val input = searchBarEditText.text.toString()
                currentSearchInput = input
                nextPageToken = null

                searchResultRecyclerView.scrollToPosition(0)
                searchViewModel.onSearch(input, set = true)
            }
        }
        searchBarEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                search()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        searchImageButton.setOnClickListener {
            search()
        }
    }

    private fun hideKeyboard() = activity?.let {
        val manager = it.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(
            it.currentFocus?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}