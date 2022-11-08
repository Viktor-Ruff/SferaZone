package com.example.sferazone1.adapters.peopleAdapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sferazone1.databinding.ItemPeopleProfilesImageBinding
import com.example.sferazone1.model.PeopleModel

/**
 * Created by Viktor-Ruff
 * Date: 08.11.2022
 * Time: 11:50
 */
class SubscribersAdapter(clickListener: ClickListener) :
    RecyclerView.Adapter<SubscribersAdapter.SubscribersViewHolder>(), Filterable {

    private var peopleList: List<PeopleModel> = arrayListOf()
    private var peopleListFiltered: List<PeopleModel> = arrayListOf()
    private var clickListener: ClickListener = clickListener

    @SuppressLint("NotifyDataSetChanged")
    fun setData(people: List<PeopleModel>) {
        this.peopleList = people
        this.peopleListFiltered = people
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscribersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPeopleProfilesImageBinding.inflate(inflater, parent, false)
        return SubscribersViewHolder(binding)
    }


    @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
    override fun onBindViewHolder(holder: SubscribersViewHolder, position: Int) {

        val people = peopleList[position]
        /*val people = listPeople[position]*/
        holder.itemView.setOnClickListener() {
            clickListener.clickedItem(people)
        }

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

    interface ClickListener {
        fun clickedItem(people: PeopleModel)
    }


    override fun getItemCount(): Int {
        return peopleList.size
    }


    class SubscribersViewHolder(
        val binding: ItemPeopleProfilesImageBinding
    ) : RecyclerView.ViewHolder(binding.root)


    override fun getFilter(): Filter {
        val filter = object : Filter() {

            override fun performFiltering(p0: CharSequence?): FilterResults {

                var filterResults = FilterResults()
                var filteredArrayList = ArrayList<PeopleModel>()

                if (p0 == null || p0.isEmpty()) {
                    filteredArrayList.addAll(peopleListFiltered)
                    /*filterResults.values = peopleListFiltered
                    filterResults.count = peopleListFiltered.size*/
                } else {
                    var searchChar = p0.toString().toLowerCase()

                    for (people in peopleListFiltered) {
                        if (people.name.toLowerCase().contains(searchChar)) {
                            filteredArrayList.add(people)
                        }
                    }

                    filterResults.values = peopleListFiltered
                    filterResults.count = peopleListFiltered.size
                }

                return filterResults
            }


            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {


                peopleList = p1!!.values as List<PeopleModel>
                notifyDataSetChanged()
            }
        }
        return filter
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

}