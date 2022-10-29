package com.example.sferazone1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Viktor-Ruff
 * Date: 27.10.2022
 * Time: 19:40
 */
class UserAdapter(private val userList: List<User>) : RecyclerView.Adapter<UserViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_image, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}