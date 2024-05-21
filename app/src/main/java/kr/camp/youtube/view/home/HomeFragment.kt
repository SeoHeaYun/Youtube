package kr.camp.youtube.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kr.camp.youtube.databinding.FragmentHomeBinding
import kr.camp.youtube.view.home.UserItem.HomeItem
import kr.camp.youtube.view.home.adapter.HomeChannelAdapter
import kr.camp.youtube.view.home.adapter.HomePopularAdapter
import kr.camp.youtube.view.home.adapter.HomeVideoAdapter
import kr.camp.youtube.view.search.adapter.SearchAdpater

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeChannelAdapter: HomeChannelAdapter

    private val homeVideoAdapter: HomeVideoAdapter by lazy {
        HomeVideoAdapter(
            onItemClick = { item -> videoAdapterOnItemClick(item)}
        )
    }

    private val homePopularAdapter: HomePopularAdapter by lazy {
        HomePopularAdapter(
            onItemClick = { item -> videoAdapterOnItemClick(item)}
        )
    }

    private fun videoAdapterOnItemClick(item: HomeItem){
        TODO("Intent")
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

        binding.categoryChannelRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = HomeChannelAdapter().apply {
                homeChannelAdapter = this
            }
        }

        binding.categoryVideoRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = homeChannelAdapter
        }

        binding.popularVideoRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = homePopularAdapter
        }

    }

    private fun registerViewModelEvent() {


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}