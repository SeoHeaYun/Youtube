package kr.camp.youtube.view.myVideo.state

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kr.camp.youtube.R
import kr.camp.youtube.databinding.FragmentMyVideoBinding
import kr.camp.youtube.view.detail.model.DummyDataManager.getDummyData
import kr.camp.youtube.view.detail.model.DummyDataManager.updateDummyData
import kr.camp.youtube.network.YoutubeRetrofitClient
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.myVideo.adapter.MyVideoAdapter


class MyVideoFragment : Fragment(R.layout.fragment_my_video) {

    private var _binding: FragmentMyVideoBinding? = null
    private val binding get() = _binding!!
    private lateinit var videoAdapter: MyVideoAdapter

    //컨텍스트
    private lateinit var mContext: Context

    //리퀘스트 코드
    companion object {
        const val VIDEO_DETAIL_REQUEST_CODE = 1
    }

    // 사용자의 좋아요를 받은 항목을 저장하는 리스트
    private var likedItems: List<LikeItemModel> = mutableListOf()

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
        binding.RecyclerView.layoutManager = gridLayoutManager

        //좋아요 더미데이터 추가
        likedItems = getDummyData()

        //좋아요 리스트와 어댑터 연결
        videoAdapter = MyVideoAdapter(likedItems.toMutableList())
        binding.RecyclerView.adapter = videoAdapter


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == VIDEO_DETAIL_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            val updatedItem = data?.getSerializableExtra("item") as? LikeItemModel
            updatedItem?.let{
                val index = videoAdapter.items.indexOfFirst { it.title == it.title }
                if (index != -1) {
                    videoAdapter.items[index] = it
                    videoAdapter.updateItems(videoAdapter.items)
                }
            }
        }
    }

    override fun onDestroyView(){
        super.onDestroyView()
        //메모리 누수를 방지하기 위해 뷰가 파괴될 때 바인딩 객체를 null로 설정
        _binding= null
    }


}