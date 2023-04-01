package com.example.appbarpro

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomViewpagerAdapterAdapter (activity: FragmentActivity) : FragmentStateAdapter(activity) {
    val fragmentList = ArrayList<Fragment>()
    override fun getItemCount(): Int = fragmentList.size
    override fun createFragment(position: Int): Fragment = fragmentList.get(position)

    fun addListFragment(fragment: Fragment) {
        this.fragmentList.add(fragment)
    }
}