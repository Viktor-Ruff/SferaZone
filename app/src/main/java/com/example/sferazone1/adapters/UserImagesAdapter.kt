package com.example.sferazone1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.sferazone1.R
import com.example.sferazone1.imageModel.ImageModel

/**
 * Created by Viktor-Ruff
 * Date: 29.10.2022
 * Time: 20:38
 */
class UserImagesAdapter(private val userImagesList: List<ImageModel>) :
    RecyclerView.Adapter<UserImagesAdapter.UserImagesViewHolder>() {

    class UserImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val userImageView: ImageView = itemView.findViewById(R.id.iv_user_image)

        fun bind(imageModel: ImageModel) {

            userImageView.setImageResource(imageModel.userImage)
        }
    }

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