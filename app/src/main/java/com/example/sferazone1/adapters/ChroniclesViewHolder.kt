package com.example.sferazone1.adapters

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.sferazone1.R
import com.example.sferazone1.imageModel.Chronicles


/**
 * Created by Viktor-Ruff
 * Date: 29.10.2022
 * Time: 23:17
 */
class ChroniclesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val chroniclesImageView: ImageView = itemView.findViewById(R.id.iv_chronicles_image)

    fun bind(chronicles: Chronicles) {

        chroniclesImageView.setImageResource(chronicles.chroniclesImage)

    }


}