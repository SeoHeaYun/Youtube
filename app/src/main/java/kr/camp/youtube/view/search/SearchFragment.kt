package kr.camp.youtube.view.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.camp.youtube.R
import kr.camp.youtube.databinding.FragmentSearchBinding
import kr.camp.youtube.view.search.adapter.SearchAdpater
import kr.camp.youtube.view.search.model.SearchViewModel
import kr.camp.youtube.view.search.model.SearchViewModelFactory

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!

    private val searchViewModel: SearchViewModel by viewModels { SearchViewModelFactory() }

    private lateinit var searchAdapter: SearchAdpater

    private val searchResultNoticeTextView get() = binding.searchResultNoticeTextView
    private val searchResultRecyclerView get() = binding.searchResultRecyclerView

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

    private fun registerRecyclerView() = with(searchResultRecyclerView) {
        layoutManager = LinearLayoutManager(context)
        adapter = SearchAdpater {}.apply {
            searchAdapter = this
        }
    }

    private fun registerViewModelEvent() = viewLifecycleOwner.lifecycleScope.launch {
        searchViewModel.uiState.flowWithLifecycle(lifecycle).collectLatest { uiState ->
            val items = uiState.items
            if (items.isEmpty()) {
                searchAdapter.update(emptyList())
                searchResultNoticeTextView.visibility = View.VISIBLE
                searchResultRecyclerView.visibility = View.GONE
            } else {
                searchAdapter.update(items)
                searchResultNoticeTextView.visibility = View.GONE
                searchResultRecyclerView.visibility = View.VISIBLE
            }
        }
    }

    private fun registerSearchBar() {
        val searchBarEditText = binding.searchBarEditText
        searchBarEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                if (searchBarEditText.text.isBlank()) {
                    Toast.makeText(context, getString(R.string.search_blank_error), Toast.LENGTH_SHORT).show()
                    return@setOnEditorActionListener true
                }
                hideKeyboard()
                searchBarEditText.clearFocus()
                searchViewModel.onSearch(searchBarEditText.text.toString())
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
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