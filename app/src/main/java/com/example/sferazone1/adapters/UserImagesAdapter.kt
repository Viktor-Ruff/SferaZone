package com.example.sferazone1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sferazone1.R
import com.example.sferazone1.imageModel.UserImages

/**
 * Created by Viktor-Ruff
 * Date: 29.10.2022
 * Time: 20:38
 */
class UserImagesAdapter(private val userImagesList: List<UserImages>) :
    RecyclerView.Adapter<UserImagesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserImagesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_images, parent, false)
        return UserImagesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserImagesViewHolder, position: Int) {
        val userImagesList = userImagesList[position]
        holder.bind(userImagesList)
    }

    override fun getItemCount(): Int {
        return userImagesList.size

    }


}