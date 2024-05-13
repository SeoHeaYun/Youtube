package kr.camp.youtube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.camp.youtube.databinding.ActivityMainBinding
import kr.camp.youtube.view.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}