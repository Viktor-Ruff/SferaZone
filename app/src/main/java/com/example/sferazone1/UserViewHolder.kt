package com.example.sferazone1

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Viktor-Ruff
 * Date: 27.10.2022
 * Time: 20:55
 */

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val nameTextView: TextView = itemView.findViewById(R.id.tv_user_name)

    private val userImageView: ImageView = itemView.findViewById(R.id.iv_user_image)

    fun bind(user: User) {

        /*nameTextView.text = "Имя - ${user.name}"*/
        userImageView.setImageResource(R.drawable.image3)
    }
}