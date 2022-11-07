package com.example.sferazone1.adapters.profileAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferazone1.R
import com.example.sferazone1.databinding.ItemUserImagesBinding
import com.example.sferazone1.model.ImageModel

/**
 * Created by Viktor-Ruff
 * Date: 29.10.2022
 * Time: 20:38
 */
class UserImagesAdapter constructor(private val userImagesList: List<ImageModel>) :
    RecyclerView.Adapter<UserImagesAdapter.UserImagesViewHolder>() {

    class UserImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemUserImagesBinding.bind(itemView)
        fun bind(imageModel: ImageModel) {
            Glide
                .with(itemView.context)
                .load(imageModel.userImage)
                .into(binding.ivUserImage)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserImagesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_images, parent, false)
        return UserImagesViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: UserImagesViewHolder, position: Int) {
        val userImage = userImagesList[position]
        holder.bind(userImage)
    }


    override fun getItemCount(): Int {
        return userImagesList.size
    }

}