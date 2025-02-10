package com.nishiket.task.viewpager

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nishiket.task.R
import com.nishiket.task.viewpager.adapter.ViewPagerAdapter
import com.nishiket.task.viewpager.horizontalfragments.AnimeFragment
import com.nishiket.task.viewpager.horizontalfragments.CarsFragment
import com.nishiket.task.viewpager.horizontalfragments.NatureFragment

class ViewPagerActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_pager)

        // all images of evey category
        val animeWallpaper = listOf(R.drawable.anime1,R.drawable.anime2,R.drawable.anime3,R.drawable.anime4,R.drawable.anime5,R.drawable.anime6)
        val natureWallpaper = listOf(R.drawable.nature1,R.drawable.nature2,R.drawable.nature3,R.drawable.nature4,R.drawable.nature5)
        val carsWallpaper = listOf(R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4)

        // category list
        val category = listOf("Anime","Cars","Nature")

        // category fragments object
        val fragments = listOf(AnimeFragment(animeWallpaper),CarsFragment(carsWallpaper),NatureFragment(natureWallpaper))

        // adapter object, setting up viewpager and offset
        val v = ViewPagerAdapter(supportFragmentManager,lifecycle,fragments)
        val viewPager= findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = v
        viewPager.offscreenPageLimit = 1

        // checking scroll behaviour
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                Log.d("scroll", "onPageScrolled: "+position)

                if(position==0 && viewPager.scrollState == ViewPager2.SCROLL_STATE_DRAGGING){
                    viewPager.setCurrentItem(2,true)
                }
                if(position==2 && viewPager.scrollState == ViewPager2.SCROLL_STATE_DRAGGING){
                    viewPager.setCurrentItem(0,true)
                }
            }
        })

        // setting up tablayout with viewpager
        tabLayout = findViewById(R.id.tablayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = category[position]
        }.attach()


    }
}