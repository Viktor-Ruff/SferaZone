package com.example.sferazone1.adapters

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
class PeopleAdapter(private val listPeople: List<PeopleModel>) :
    RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPeopleProfilesImageBinding.inflate(inflater, parent, false)
        return PeopleViewHolder(binding)
    }


    @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val people = listPeople[position]

        with(holder.binding) {
            tvPeopleProfileName.text = people.name
            tvPeopleProfileSubscribe.isChecked = people.status

            if (people.status) {
                tvPeopleProfileSubscribe.text = "Unsubscribe"
            } else {
                tvPeopleProfileSubscribe.text = "Subscribe"
            }

            with(holder.binding) {
                tvPeopleProfileName.text = people.name
                Glide
                    .with(ivPeopleProfileImage.context)
                    .load(people.profileImage)
                    .circleCrop()
                    .into(ivPeopleProfileImage)
            }

            tvPeopleProfileSubscribe.setOnClickListener() {

                people.status = !people.status
                notifyDataSetChanged()
            }
        }
    }


    override fun getItemCount(): Int {
        return listPeople.size
    }


    class PeopleViewHolder(
        val binding: ItemPeopleProfilesImageBinding
    ) : RecyclerView.ViewHolder(binding.root)

}