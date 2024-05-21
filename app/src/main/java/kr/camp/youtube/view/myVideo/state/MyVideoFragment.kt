package kr.camp.youtube.view.myVideo.state

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.launch
import kr.camp.youtube.BuildConfig
import kr.camp.youtube.R
import kr.camp.youtube.databinding.FragmentMyVideoBinding
import kr.camp.youtube.network.YoutubeRetrofitClient
import kr.camp.youtube.view.detail.VideoDetailActivity
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.main.MainActivity
import kr.camp.youtube.view.myVideo.adapter.MyVideoAdapter


class MyVideoFragment : Fragment(R.layout.fragment_my_video) {

    private var _binding: FragmentMyVideoBinding? = null
    private val binding get() = _binding!!
    private lateinit var videoAdapter: MyVideoAdapter

    //컨텍스트
    private lateinit var mContext: Context

    // 사용자의 좋아요를 받은 항목을 저장하는 리스트
    private var likedItems: List<LikeItemModel> = listOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMyVideoBinding.bind(view)

        val gridLayoutManager = GridLayoutManager(requireContext(),2)
        binding.recylclerView.layoutManager = gridLayoutManager

        //메인액티비티에서 좋아요 목록 가져오기
        val detailActivity = activity as VideoDetailActivity
        likedItems = detailActivity.likedItems

        //좋아요 리스트와 어댑터 연결
        videoAdapter = MyVideoAdapter(likedItems.toMutableList())
        binding.recylclerView.adapter = videoAdapter

        //유튜브 비디오 썸네일 가져오기
        fetchVideos()
    }

    private fun fetchVideos(){
        val apiKey = BuildConfig.YOUTUBE_API_KEY

        lifecycleScope.launch{
            try {
                val response = YoutubeRetrofitClient.searchDataSource.getSearch(
                    query = "Android development",
                    apiKey = apiKey,
                    pageToken = ""
                )

                //아이템 업데이트
                videoAdapter.notifyDataSetChanged()

            } catch(e:Exception){
                Toast.makeText(requireContext(),"영상을 불러오는데 실패하였습니다",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView(){
        super.onDestroyView()
        //메모리 누수를 방지하기 위해 뷰가 파괴될 때 바인딩 객체를 null로 설정
        _binding= null
    }


}