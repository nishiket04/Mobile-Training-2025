package com.nishiket.task.viewpager.horizontalfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.nishiket.task.R
import com.nishiket.task.viewpager.adapter.VerticalViewPagerAdapter

class AnimeFragment(private val animeWallpaper:List<Int>) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // setting up viewpager and giving offset
        view.findViewById<ViewPager2>(R.id.animeViewPager).adapter = VerticalViewPagerAdapter(parentFragmentManager,lifecycle,animeWallpaper)
        view.findViewById<ViewPager2>(R.id.animeViewPager).offscreenPageLimit = 2
    }
}