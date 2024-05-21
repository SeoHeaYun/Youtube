package kr.camp.youtube.view.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kr.camp.youtube.R
import kr.camp.youtube.databinding.FragmentHomeBinding
import kr.camp.youtube.view.detail.VideoDetailActivity
import kr.camp.youtube.view.home.state.HomeItem
import kr.camp.youtube.view.home.adapter.HomeMostPopularAdapter
import kr.camp.youtube.view.home.adapter.HomeCategoryPopularAdapter
import kr.camp.youtube.view.home.model.VideoViewModel
import kr.camp.youtube.view.home.model.VideoViewModelFactory
import kr.camp.youtube.view.home.state.CategoryPopularAddList
import kr.camp.youtube.view.home.state.CategoryPopularResultEmpty
import kr.camp.youtube.view.home.state.MostPopularResultEmpty
import kr.camp.youtube.view.home.state.MostPopularVideoAddList


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val videoViewModel: VideoViewModel by viewModels { VideoViewModelFactory() }

    private lateinit var clickButton: List<TextView>

    private val musicCategory by lazy { binding.musicTextView }
    private val sportsCategory by lazy { binding.sportTextView }
    private val movieCategory by lazy { binding.movieTextView }
    private val gateCategory by lazy { binding.gameTextView }
    private val newsCategory by lazy { binding.newsTextView }
    private val travelCategory by lazy { binding.travelTextView }
    private val animalCategory by lazy { binding.animalTextView }

    private var currentCategory: TextView? = null

    private val homeCategoryPopularAdapter: HomeCategoryPopularAdapter by lazy {
        HomeCategoryPopularAdapter(
            onItemClick = { item -> videoAdapterOnItemClick(item) }
        )
    }

    private val homeMostPopularAdapter: HomeMostPopularAdapter by lazy {
        HomeMostPopularAdapter(
            onItemClick = { item -> videoAdapterOnItemClick(item) }
        )
    }

    private fun videoAdapterOnItemClick(item: HomeItem) {
        val detailActivity = activity as? VideoDetailActivity
        detailActivity?.receiveHomeDataList(item)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerRecyclerView()
        registerViewModelEvent()
    }

    private fun registerRecyclerView() {

        videoViewModel.getMostPopularVideo("mostPopular")
        dataUpdate(musicCategory, "10")

        binding.categoryPopularRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = homeCategoryPopularAdapter
        }

        binding.mostPopularRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = homeMostPopularAdapter
        }

        clickButton = listOf(
            musicCategory,
            sportsCategory,
            movieCategory,
            gateCategory,
            newsCategory,
            travelCategory,
            animalCategory
        )

        clickButton.forEach { button ->
            button.setOnClickListener { ButtonClickEvent(button) }
        }
    }

    private fun ButtonClickEvent(clickCategory: TextView) {
        when (clickCategory) {
            musicCategory -> dataUpdate(clickCategory, "10")
            sportsCategory -> dataUpdate(clickCategory, "17")
            movieCategory -> dataUpdate(clickCategory, "1")
            gateCategory -> dataUpdate(clickCategory, "20")
            newsCategory -> dataUpdate(clickCategory, "25")
            travelCategory -> dataUpdate(clickCategory, "22")
            animalCategory -> dataUpdate(clickCategory, "15")
        }
    }

    private fun dataUpdate(clickButton: TextView, categoryId: String) {
        currentCategory?.apply {
            setBackgroundResource(R.drawable.home_default_category_background)
            setTextColor(Color.BLACK)
        }
        clickButton.apply {
            setBackgroundResource(R.drawable.home_selected_category_background)
            setTextColor(Color.WHITE)
        }
        currentCategory = clickButton
        videoViewModel.getCategoriesPopularVideo("mostPopular", categoryId)
    }


    private fun registerViewModelEvent() = binding.apply {
        viewLifecycleOwner.lifecycleScope.launch {
            combine(
                videoViewModel.categoriesPopularVideoUiState.flowWithLifecycle(lifecycle),
                videoViewModel.mostPopularVideoUiState.flowWithLifecycle(lifecycle)
            ) { categoriesPopularVideoUiState, mostPopularVideoUiState ->
                Pair(categoriesPopularVideoUiState, mostPopularVideoUiState)
            }.collectLatest { (categoriesPopularVideoUiState, mostPopularVideoUiState) ->

                when (categoriesPopularVideoUiState) {
                    is CategoryPopularResultEmpty -> homeCategoryPopularAdapter.clearItems()
                    is CategoryPopularAddList -> homeCategoryPopularAdapter.updateItem(
                        categoriesPopularVideoUiState.categoryPopularItems
                    )

                    else -> {}
                }
                when (mostPopularVideoUiState) {
                    is MostPopularResultEmpty -> homeMostPopularAdapter.clearItems()
                    is MostPopularVideoAddList -> homeMostPopularAdapter.updateItem(
                        mostPopularVideoUiState.mostPopularItems
                    )

                    else -> {}
                }


            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
