package com.example.sferazone1.adapters.badAdapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sferazone1.PeopleScreenFragment
import com.example.sferazone1.model.PeopleModel
import com.example.sferazone1.model.UserService

/**
 * Created by Viktor-Ruff
 * Date: 06.11.2022
 * Time: 20:13
 */
class TabAdapter /*constructor(
    private val listPeople: List<PeopleModel>,
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    val userService:UserService = UserService()


    override fun createFragment(position: Int): SubscribersAdapter {
       return when  (position) {

           0 -> SubscribersAdapter(userService.initPeopleList(40))


       }

    }

    override fun getItemCount(): Int {
        return 3
    }
}*/