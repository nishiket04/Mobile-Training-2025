package com.nishiket.task.viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

// Adapter that accept fragmentManager,life cycle and list of horizontal category fragment
class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle,val fragments: List<Fragment>): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}