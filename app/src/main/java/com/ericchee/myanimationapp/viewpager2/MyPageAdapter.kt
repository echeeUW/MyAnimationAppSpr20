package com.ericchee.myanimationapp.viewpager2

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ericchee.myanimationapp.viewpager2.pages.FirstPageFragment
import com.ericchee.myanimationapp.viewpager2.pages.SecondPageFragment

class MyPageAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {

    private val listOfFragments = listOf(
        FirstPageFragment.newInstance(),
        SecondPageFragment.newInstance()
    )

    override fun getItemCount(): Int = listOfFragments.size

    override fun createFragment(position: Int): Fragment {
        return listOfFragments[position]
    }
}