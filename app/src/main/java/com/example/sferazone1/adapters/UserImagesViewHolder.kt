package com.example.sferazone1.adapters

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.sferazone1.R
import com.example.sferazone1.imageModel.UserImages

/**
 * Created by Viktor-Ruff
 * Date: 29.10.2022
 * Time: 20:37
 */
class UserImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val userImageView: ImageView = itemView.findViewById(R.id.iv_user_image)

    fun bind(userImages: UserImages) {

        userImageView.setImageResource(userImages.userImage)
    }
}