package com.example.sferazone1.adapters.peopleAdapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferazone1.databinding.ItemPeopleProfilesImageBinding
import com.example.sferazone1.model.PeopleModel

/**
 * Created by Viktor-Ruff
 * Date: 02.11.2022
 * Time: 18:15
 */
class SubscribersAdapter constructor(private val listPeople: List<PeopleModel>) :
    RecyclerView.Adapter<SubscribersAdapter.SubscribersViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscribersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPeopleProfilesImageBinding.inflate(inflater, parent, false)
        return SubscribersViewHolder(binding)
    }


    @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
    override fun onBindViewHolder(holder: SubscribersViewHolder, position: Int) {
        val people = listPeople[position]

        with(holder.binding) {
            tvPeopleProfileName.text = people.name
            tvPeopleProfileSubscribe.isChecked = people.status

            if (people.status) {
                tvPeopleProfileSubscribe.text = "Unsubscribe"
            } else {
                tvPeopleProfileSubscribe.text = "Subscribe"
            }

            Glide
                .with(ivPeopleProfileImage.context)
                .load(people.profileImage)
                .circleCrop()
                .into(ivPeopleProfileImage)

            tvPeopleProfileSubscribe.setOnClickListener() {
                people.status = !people.status
                notifyDataSetChanged()
            }
        }
    }


    override fun getItemCount(): Int {
        return listPeople.size
    }


    class SubscribersViewHolder(
        val binding: ItemPeopleProfilesImageBinding
    ) : RecyclerView.ViewHolder(binding.root)

}