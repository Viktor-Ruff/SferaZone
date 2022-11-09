package com.example.sferazone1.viewModel

import com.example.sferazone1.view.peopleAdapters.PeopleAdapter
import com.example.sferazone1.model.PeopleModel

/**
 * Created by Viktor-Ruff
 * Date: 09.11.2022
 * Time: 19:33
 */

class ListFilter(listAdapter: PeopleAdapter, list: List<PeopleModel>) {

    private var listAdapter: PeopleAdapter
    private var list: List<PeopleModel>

    init {
        this.listAdapter = listAdapter
        this.list = list
    }


    fun filterList(text: String) {

        var filteredArrayList = ArrayList<PeopleModel>()

        for (people in list) {
            if (people.name.toLowerCase().contains(text.toLowerCase())) {
                filteredArrayList.add(people)
            } else {
                filteredArrayList.remove(people)
            }
        }
        listAdapter.setFilteredList(filteredArrayList)

    }

}