package com.nishiket.task.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.nishiket.task.viewpager.ImageFragment

// Adapter that accept fragmentManager,life cycle and list of vertical category's image
class VerticalViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle,val images:List<Int>):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int = images.size

    override fun createFragment(position: Int): Fragment  = ImageFragment(images[position])
}