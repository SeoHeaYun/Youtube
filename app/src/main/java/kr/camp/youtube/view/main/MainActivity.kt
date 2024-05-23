package kr.camp.youtube.view.main

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import kr.camp.youtube.R
import kr.camp.youtube.databinding.ActivityMainBinding
import kr.camp.youtube.view.detail.VideoDetailActivity
import kr.camp.youtube.view.detail.model.LikeItemModel
import kr.camp.youtube.view.myvideo.state.MyVideoFragment
import kr.camp.youtube.view.home.HomeFragment
import kr.camp.youtube.view.intent.item.DetailItem
import kr.camp.youtube.view.registry.DetailItemRegistry
import kr.camp.youtube.view.search.SearchFragment
import kr.camp.youtube.view.search.state.item.SearchItem

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
        loadLikes()
        viewPager()
    }

    private fun loadLikes() {
        val sharedPreferences = getSharedPreferences("Yuktube2222", Context.MODE_PRIVATE)
        val jsonLikes = sharedPreferences.getStringSet("likes", emptySet()) ?: emptySet()
        val likes = jsonLikes.map {
            val split = it.split("|", limit = 2)
            val className = split[0]
            val clazz = Class.forName(className)
            val jsonLike = split[1]
            gson.fromJson(jsonLike, clazz) as DetailItem
        }.toMutableSet()
        DetailItemRegistry.setLikes(likes)
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

    private companion object {
        val gson = Gson()
    }
}




