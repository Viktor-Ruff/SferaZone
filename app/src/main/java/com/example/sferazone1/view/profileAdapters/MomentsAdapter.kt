package com.example.sferazone1.view.profileAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferazone1.R
import com.example.sferazone1.databinding.ItemMomentsImageBinding
import com.example.sferazone1.model.ImageModel

/**
 * Created by Viktor-Ruff
 * Date: 27.10.2022
 * Time: 19:40
 */

class MomentsAdapter constructor(private val listImages: List<ImageModel>) :
    RecyclerView.Adapter<MomentsAdapter.MomentsHolder>() {

    class MomentsHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemMomentsImageBinding.bind(item)
        fun bind(item: ImageModel) {
            Glide
                .with(itemView.context)
                .load(item.userImage)
                .into(binding.ivMomentsImage)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_moments_image, parent, false)
        return MomentsHolder(view)
    }


    override fun onBindViewHolder(holder: MomentsHolder, position: Int) {
        holder.bind(listImages[position])
    }


    override fun getItemCount(): Int {
        return listImages.size
    }
}
