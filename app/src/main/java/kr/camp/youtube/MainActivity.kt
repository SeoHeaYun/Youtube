package kr.camp.youtube

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kr.camp.youtube.databinding.ActivityMainBinding
import java.lang.IndexOutOfBoundsException

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var currentPosition = 0

    val whiteIcon = listOf(
        R.drawable.home_white,
        R.drawable.search_white,
        R.drawable.youtube_white
    )

    val blackIcon = listOf(
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


        val tabIcons = if (currentPosition == 0) blackIcon else whiteIcon

        viewPager.adapter = ViewPagerAdapter(fragmentList, this@MainActivity)

        // ViewPager2 - TabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(whiteIcon[position])
        }.attach()

        // TabLayout Click Event (Icon Change)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentPosition = position
                tabLayout.getTabAt(position)?.setIcon(getIconResource(position))
                }
        })
    }
    private fun getIconResource(position: Int): Int {
        return if (currentPosition == position) blackIcon[position] else whiteIcon[position]
    }
}





