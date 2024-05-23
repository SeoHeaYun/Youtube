package kr.camp.youtube.view.myvideo.state

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kr.camp.youtube.R
import kr.camp.youtube.databinding.FragmentMyVideoBinding
import kr.camp.youtube.view.detail.model.DummyDataManager
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.detail.model.SharedPreferencesManager
import kr.camp.youtube.view.intent.IntentKey
import kr.camp.youtube.view.myvideo.adapter.MyVideoAdapter
import kr.camp.youtube.view.myvideo.adapter.MyVideoViewModel


class MyVideoFragment : Fragment(R.layout.fragment_my_video) {

    private var _binding: FragmentMyVideoBinding? = null
    private val binding get() = _binding!!
    private lateinit var videoAdapter: MyVideoAdapter

    //뷰모델
    private val viewModel: MyVideoViewModel by viewModels()

    //리퀘스트 코드
    companion object {
        const val VIDEO_DETAIL_REQUEST_CODE = 1
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

        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        binding.RecyclerView.layoutManager = gridLayoutManager

        videoAdapter = MyVideoAdapter(requireContext(), listOf())
        binding.RecyclerView.adapter = videoAdapter

        viewModel.likedItems.observe(viewLifecycleOwner, Observer { likedItems ->
            videoAdapter.updateItems(likedItems)
        })

        viewModel.updateLikedItems()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == VIDEO_DETAIL_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            viewModel.updateLikedItems()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //메모리 누수를 방지하기 위해 뷰가 파괴될 때 바인딩 객체를 null로 설정
        _binding = null
    }


}