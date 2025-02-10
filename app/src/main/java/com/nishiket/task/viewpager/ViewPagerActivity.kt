package com.nishiket.task.viewpager

import android.os.Bundle
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        val animeWallpaper = listOf(R.drawable.anime1,R.drawable.anime2,R.drawable.anime3,R.drawable.anime4,R.drawable.anime5,R.drawable.anime6)
        val natureWallpaper = listOf(R.drawable.nature1,R.drawable.nature2,R.drawable.nature3,R.drawable.nature4,R.drawable.nature5)
        val carsWallpaper = listOf(R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4)
        val category = listOf("Anime","Cars","Nature")
        val fragments = listOf(AnimeFragment(animeWallpaper),CarsFragment(carsWallpaper),NatureFragment(natureWallpaper))
        val v = ViewPagerAdapter(supportFragmentManager,lifecycle,fragments)
        val viewPager= findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = v
        viewPager.offscreenPageLimit = 1
        val tabLayout: TabLayout = findViewById(R.id.tablayout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = category[position]
        }.attach()
    }
}