package com.example.sferazone1.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.example.sferazone1.R
import com.example.sferazone1.imageModel.Moments

/**
 * Created by Viktor-Ruff
 * Date: 27.10.2022
 * Time: 20:55
 */

class MomentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val momentsImageView: ImageView = itemView.findViewById(R.id.iv_moments_image)

    fun bind(moments: Moments) {

        momentsImageView.setImageResource(moments.momentImage)

    }
}