package com.nishiket.task.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nishiket.task.R
import com.nishiket.task.fragment.adapter.ViewPagerScreenAdapter
import com.nishiket.task.fragment.fragmentsview.DisplayFragment
import com.nishiket.task.fragment.fragmentsview.MainFragment
import com.nishiket.task.fragment.fragmentsview.ModifyFragment

class FragmentActivity : AppCompatActivity() {
    private lateinit var tabLayoutNavigator: TabLayout
    private lateinit var viewPagerScreen: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        // assigning id's using function
        findId()
        // list of fragments
        val fragmentList: List<Fragment> =
            listOf(MainFragment(), ModifyFragment(), DisplayFragment())
        // list of tabLayout title
        val tabTitleList: List<String> = listOf("Main", "Modify", "Display")
        // sets the adapter on viewpager view
        viewPagerScreen.adapter = ViewPagerScreenAdapter(supportFragmentManager,lifecycle,fragmentList)
        viewPagerScreen.offscreenPageLimit = 1 // to load the fragments
        // set tab and viewpager on tab
        TabLayoutMediator(tabLayoutNavigator,viewPagerScreen){tab, position ->
            tab.text = tabTitleList[position]
        }.attach()
    }

    // Function to find Id's of the view
    fun findId() {
        tabLayoutNavigator = findViewById(R.id.tabLayoutNavigator)
        viewPagerScreen = findViewById(R.id.viewPagerScreen)
    }
}