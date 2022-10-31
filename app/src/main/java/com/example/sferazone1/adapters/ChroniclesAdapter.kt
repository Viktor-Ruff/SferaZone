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
 * Time: 23:11
 */
class ChroniclesAdapter(private val chroniclesImagesList: List<ImageModel>) :
    RecyclerView.Adapter<ChroniclesAdapter.ChroniclesViewHolder>() {

    class ChroniclesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val chroniclesImageView: ImageView = itemView.findViewById(R.id.iv_chronicles_image)

        fun bind(imageModel: ImageModel) {

            chroniclesImageView.setImageResource(imageModel.userImage)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChroniclesViewHolder {

        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chronicles_image, parent, false)
        return ChroniclesViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ChroniclesViewHolder, position: Int) {
        val chroniclesImagesList = chroniclesImagesList[position]
        holder.bind(chroniclesImagesList)
    }

    override fun getItemCount(): Int {
        return chroniclesImagesList.size
    }


}