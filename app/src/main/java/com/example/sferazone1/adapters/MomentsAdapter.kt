package com.example.sferazone1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sferazone1.imageModel.Moments
import com.example.sferazone1.R

/**
 * Created by Viktor-Ruff
 * Date: 27.10.2022
 * Time: 19:40
 */
class MomentsAdapter(private val momentsList: List<Moments>) :
    RecyclerView.Adapter<MomentsViewHolder>() {

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