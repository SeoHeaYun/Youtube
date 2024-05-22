package kr.camp.youtube.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kr.camp.youtube.R
import kr.camp.youtube.databinding.ActivityMainBinding
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.myvideo.state.MyVideoFragment
import kr.camp.youtube.view.home.HomeFragment
import kr.camp.youtube.view.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val whiteIcons = listOf(
        R.drawable.home_white,
        R.drawable.search_white,
        R.drawable.youtube_white
    )

    val blackIcons = listOf(
        R.drawable.home_black,
        R.drawable.search_black,
        R.drawable.youtube_black
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewPager()
    }

    //ViewPager2
    private fun viewPager() {
        val fragmentList = ArrayList<Fragment>().apply {
            add(HomeFragment())
            add(SearchFragment())
            add(MyVideoFragment())
        }

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        viewPager.apply {
            adapter = ViewPagerAdapter(fragmentList, this@MainActivity)
            isUserInputEnabled = false // Swipe unabled
        }

        // ViewPager2 - TabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(whiteIcons[position])
        }.attach()

        // TabLayout Click Event (Icon Change)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                for (i in 0 until tabLayout.tabCount) {
                    tabLayout.getTabAt(i)?.setIcon(getIconResource(i, position))
                }
            }
        })
    }

    private fun getIconResource(tabIndex: Int, currentPosition: Int): Int {
        return if (tabIndex == currentPosition) blackIcons[tabIndex] else whiteIcons[tabIndex]
    }

    // 좋아요를 눌러 선택된 아이템을 저장하는 리스트
    var likedItems: ArrayList<LikeItemModel> = ArrayList()


}




