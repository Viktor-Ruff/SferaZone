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
 * Date: 27.10.2022
 * Time: 19:40
 */
class MomentsAdapter(private val momentsList: List<ImageModel>) :
    RecyclerView.Adapter<MomentsAdapter.MomentsViewHolder>() {

    class MomentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val momentsImageView: ImageView = itemView.findViewById(R.id.iv_moments_image)

        fun bind(imageModel: ImageModel) {

            momentsImageView.setImageResource(imageModel.userImage)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MomentsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_moments_image, parent, false)
        return MomentsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MomentsViewHolder, position: Int) {
        val momentsList = momentsList[position]
        holder.bind(momentsList)
    }

    override fun getItemCount(): Int {
        return momentsList.size
    }

}