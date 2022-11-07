package com.example.sferazone1.adapters.badAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sferazone1.adapters.peopleAdapters.PeopleAdapter
import com.example.sferazone1.adapters.peopleAdapters.SubscribersAdapter
import com.example.sferazone1.databinding.FragmentPeopleScreenBinding
import com.example.sferazone1.model.UserService

/**
 * Created by Viktor-Ruff
 * Date: 02.11.2022
 * Time: 18:15
 */
class Subscribers :
    RecyclerView.Adapter<Subscribers.SubscribersViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscribersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentPeopleScreenBinding.inflate(inflater, parent, false)
        return SubscribersViewHolder(binding)
    }


    override fun onBindViewHolder(holder: SubscribersViewHolder, position: Int) {

        val userService = UserService()
        val subscribersAdapter = PeopleAdapter(userService.initPeopleList(10))
        val subscriptionAdapter = PeopleAdapter(userService.initPeopleList(4))
        val mutuallyAdapter = PeopleAdapter(userService.initPeopleList(2))


        /*with(holder.binding) {
            when (position) {
                0 -> peopleRecycler.adapter = subscribersAdapter

                1 -> peopleRecycler.adapter = subscriptionAdapter

                2 -> peopleRecycler.adapter = mutuallyAdapter
            }
        }*/

    }


    override fun getItemCount(): Int {
        return 3
    }


    class SubscribersViewHolder(
        val binding: FragmentPeopleScreenBinding
    ) : RecyclerView.ViewHolder(binding.root)

}