package com.example.sferazone1.adapters.peopleAdapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.FilterQueryProvider
import android.widget.Filterable
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
    ListAdapter<PeopleModel, PeopleAdapter.PeopleViewHolder>(ItemComparator())/*, Filterable*/ {


    private var peopleList = ArrayList<PeopleModel>()
    /*private var peopleListFiltered: List<PeopleModel> = arrayListOf()*/

    override fun submitList(list: MutableList<PeopleModel>?) {
        if (list != null) {
            this.peopleList = list as ArrayList<PeopleModel>
            /* this.peopleListFiltered = peopleList*/
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
            tvPeopleProfileSubscribe.isChecked = people.status

            if (people.status) {
                tvPeopleProfileSubscribe.text = context.resources.getText(R.string.unSubscribe)
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
                notifyDataSetChanged()
            }
        }

    }

    interface ClickListener {
        fun clickedItem(people: PeopleModel)
    }


    /*override fun getFilter(): Filter {
        val filter = object : Filter() {

            override fun performFiltering(p0: CharSequence?): FilterResults {

                var filterResults = FilterResults()
                var filteredArrayList = ArrayList<PeopleModel>()

                if (p0 == null || p0.isEmpty()) {
                    *//*filteredArrayList.addAll(peopleListFiltered)*//*
                    filterResults.values = peopleListFiltered
                    filterResults.count = peopleListFiltered.size
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
    }*/


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
        val binding: ItemPeopleProfilesImageBinding
    ) : RecyclerView.ViewHolder(binding.root)


}