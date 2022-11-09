package com.example.sferazone1.view.peopleAdapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created by Viktor-Ruff
 * Date: 07.11.2022
 * Time: 12:46
 */
class PeoplePagerAdapter(fa: FragmentActivity, private val list: List<Fragment>) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}