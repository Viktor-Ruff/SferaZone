package com.example.sferazone1.adapters.peopleAdapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferazone1.R

import com.example.sferazone1.databinding.ItemPeopleProfilesImageBinding
import com.example.sferazone1.model.PeopleModel

/**
 * Created by Viktor-Ruff
 * Date: 06.11.2022
 * Time: 18:18
 */
class PeopleAdapter :
    ListAdapter<PeopleModel, PeopleAdapter.PeopleViewHolder>(ItemComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPeopleProfilesImageBinding.inflate(inflater, parent, false)
        return PeopleViewHolder(binding)
    }


    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ItemComparator : DiffUtil.ItemCallback<PeopleModel>() {

        override fun areItemsTheSame(oldItem: PeopleModel, newItem: PeopleModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PeopleModel, newItem: PeopleModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

        override fun getChangePayload(oldItem: PeopleModel, newItem: PeopleModel): Any? {
            return oldItem.status != newItem.status
        }
    }


    class PeopleViewHolder(
        private val binding: ItemPeopleProfilesImageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val context = itemView.context

        fun bind(people: PeopleModel) = with(binding) {
            tvPeopleProfileName.text = people.name
            tvPeopleProfileSubscribe.isChecked = people.status

            if (people.status) {
                tvPeopleProfileSubscribe.text = context.resources.getText(R.string.subscribe)
            } else {
                tvPeopleProfileSubscribe.text = context.resources.getText(R.string.subscribe)
            }

            Glide
                .with(ivPeopleProfileImage.context)
                .load(people.profileImage)
                .circleCrop()
                .into(ivPeopleProfileImage)

            tvPeopleProfileSubscribe.setOnClickListener() {
                people.status = !people.status

            }
        }

    }
}