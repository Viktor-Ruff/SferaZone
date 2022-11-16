package com.example.sferazone1.view.peopleAdapters

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

class PeopleAdapter(private var clickListener: ClickListener) :
    ListAdapter<PeopleModel, PeopleAdapter.PeopleViewHolder>(ItemComparator()) {

    private var peopleList = ArrayList<PeopleModel>()

    override fun submitList(list: MutableList<PeopleModel>?) {
        if (list != null) {
            this.peopleList = list as ArrayList<PeopleModel>
        }
        super.submitList(list)
    }

    fun setFilteredList(filteredList: List<PeopleModel>) {
        this.peopleList.clear()
        this.peopleList.addAll(filteredList)

        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPeopleProfilesImageBinding.inflate(inflater, parent, false)
        return PeopleViewHolder(binding)
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {

        val context = holder.binding.root
        val people = peopleList[position]

        holder.itemView.setOnClickListener() {
            clickListener.clickedItem(people)
        }

        with(holder.binding) {

            tvPeopleProfileName.text = people.name
            tvPeopleProfileSubscribe.isChecked = people.subscription

            tvPeopleProfileSubscribe.setOnClickListener {
                onItemClickListener?.let { click ->
                    click(
                        PeopleModel(
                            id = people.id,
                            profileImage = people.profileImage,
                            name = people.name,
                            subscription = !people.subscription,
                            subscriber = people.subscriber
                        )
                    )
                }
            }

            if (people.subscription) {
                tvPeopleProfileSubscribe.text = context.resources.getText(R.string.unSubscribe)
            } else {
                tvPeopleProfileSubscribe.text = context.resources.getText(R.string.subscribe)
            }

            Glide
                .with(ivPeopleProfileImage.context)
                .load(people.profileImage)
                .circleCrop()
                .into(ivPeopleProfileImage)
        }
    }


    private var onItemClickListener: ((PeopleModel) -> Unit)? = null

    fun setOnItemClickListener(user: (PeopleModel) -> Unit) {
        onItemClickListener = user
    }


    interface ClickListener {
        fun clickedItem(people: PeopleModel)
    }


    class ItemComparator : DiffUtil.ItemCallback<PeopleModel>() {
        override fun areItemsTheSame(oldItem: PeopleModel, newItem: PeopleModel): Boolean {
            return oldItem.id == newItem.id
        }


        override fun areContentsTheSame(oldItem: PeopleModel, newItem: PeopleModel): Boolean {
            return oldItem == newItem
        }


        override fun getChangePayload(oldItem: PeopleModel, newItem: PeopleModel): Any {
            return oldItem.subscription != newItem.subscription
        }
    }


    class PeopleViewHolder(
        val binding: ItemPeopleProfilesImageBinding
    ) : RecyclerView.ViewHolder(binding.root)

}