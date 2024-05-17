package kr.camp.youtube.myVideo.state

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.camp.youtube.databinding.FragmentMyVideoBinding
import kr.camp.youtube.myVideo.adapter.MyVideoAdapter

/**
 * A simple [Fragment] subclass.
 * Use the [MyVideoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyVideoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var _binding: FragmentMyVideoBinding? = null
    private val binding get() = _binding!!

    private lateinit var videoAdapter: MyVideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyVideoBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        val gridLayoutManager = GridLayoutManager(requireContext(),2)
        binding.recylclerView.layoutManager = gridLayoutManager

        val videoList = listOf(
            //좋아요 비디오 리스트
        )

        videoAdapter = MyVideoAdapter(videoList)
        binding.recylclerView.adapter = videoAdapter

    }



    private fun openGallery(){
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        startActivityForResult(intent, 1)
    }
}