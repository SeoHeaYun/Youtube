package kr.camp.youtube.view.myVideo.state

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.launch
import kr.camp.youtube.BuildConfig
import kr.camp.youtube.R
import kr.camp.youtube.databinding.FragmentMyVideoBinding
import kr.camp.youtube.network.YoutubeRetrofitClient
import kr.camp.youtube.view.myVideo.adapter.MyVideoAdapter


class MyVideoFragment : Fragment(R.layout.fragment_my_video) {

    private var binding: FragmentMyVideoBinding? = null
    private lateinit var videoAdapter: MyVideoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMyVideoBinding.bind(view)

        val gridLayoutManager = GridLayoutManager(requireContext(),2)
        binding!!.recylclerView.layoutManager = gridLayoutManager

        fetchVideos()
    }

    private fun fetchVideos(){
        val apiKey = BuildConfig.YOUTUBE_API_KEY

        lifecycleScope.launch{
            try {
                val response = YoutubeRetrofitClient.searchDataSource.getSearch(
                    query = "Android development",
                    apiKey = apiKey
                )
                videoAdapter = MyVideoAdapter(response.items)
                binding!!.recylclerView.adapter = videoAdapter
            } catch(e:Exception){
                Toast.makeText(requireContext(),"영상을 불러오는데 실패하였습니다",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView(){
        super.onDestroyView()
        //메모리 누수를 방지하기 위해 뷰가 파괴될 때 바인딩 객체를 null로 설정
        binding= null
    }


}