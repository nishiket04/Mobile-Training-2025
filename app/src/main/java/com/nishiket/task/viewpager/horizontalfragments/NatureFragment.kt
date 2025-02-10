package com.nishiket.task.viewpager.horizontalfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.nishiket.task.R
import com.nishiket.task.viewpager.ViewPagerActivity
import com.nishiket.task.viewpager.adapter.VerticalViewPagerAdapter

class NatureFragment(private val natureWallpaper:List<Int>) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nature, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // setting up viewpager and giving offset
        view.findViewById<ViewPager2>(R.id.natureViewPager).adapter = VerticalViewPagerAdapter(parentFragmentManager,lifecycle,natureWallpaper)
        view.findViewById<ViewPager2>(R.id.natureViewPager).offscreenPageLimit = 2

        // added same tab go to first image
        val a = activity as? ViewPagerActivity
        a?.tabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                view.findViewById<ViewPager2>(R.id.natureViewPager).currentItem=0
            }

        })
    }

}