package com.example.sferazone1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Filter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.sferazone1.adapters.peopleAdapters.PeopleAdapter
import com.example.sferazone1.adapters.peopleAdapters.SubscribersAdapter
import com.example.sferazone1.databinding.FragmentListBinding
import com.example.sferazone1.model.PeopleModel
import com.example.sferazone1.model.UserService


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM_NAME = "paramName"


class ListFragment : Fragment(), PeopleAdapter.ClickListener, SubscribersAdapter.ClickListener,
    OnQueryTextListener {
    private var peopleListFiltered: List<PeopleModel> = arrayListOf()
    private var paramName: String? = null
    private var param1: Int = 0
    private lateinit var peopleAdapter: PeopleAdapter
    private lateinit var subscribersAdapter: SubscribersAdapter
    private lateinit var binding: FragmentListBinding
    private lateinit var peopleList: List<PeopleModel>
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            paramName = it.getString(ARG_PARAM_NAME)
        }

        binding = FragmentListBinding.bind(view)


        val userService = UserService()

        peopleList = userService.initPeopleList(param1)
        peopleListFiltered = peopleList

        peopleAdapter = PeopleAdapter(this)
        peopleAdapter.submitList(peopleList.toMutableList())
        binding.peopleRecycler.adapter = peopleAdapter

        initSearchView()


        /*subscribersAdapter = SubscribersAdapter(this)
        subscribersAdapter.setData(userService.initPeopleList(param1))
        binding.peopleRecycler.adapter = subscribersAdapter*/

    }

    fun initSearchView() {
        searchView = binding.searchView
        searchView.clearFocus()
        searchView.setOnQueryTextListener(this)
    }

    companion object {


        @JvmStatic
        fun newInstance(param1: Int) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM_NAME, paramName)
                }
            }
    }


    override fun clickedItem(people: PeopleModel) {
        findNavController().navigate(R.id.action_peopleScreenFragment_to_selectedUserScreenFragment)

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            filterList(newText)
        }

        return true
    }


    private fun filterList(text: String) {

        var filteredArrayList = ArrayList<PeopleModel>()





        for (people in peopleList) {
            if (people.name.toLowerCase().contains(text.toLowerCase())) {
                filteredArrayList.add(people)
            } else {
                filteredArrayList.remove(people)
            }
        }

        if (filteredArrayList.isEmpty()) {
            filteredArrayList.addAll(peopleListFiltered)
        } else {
            peopleAdapter.setFilteredList(filteredArrayList)
        }


        /*if (text == null || text.isEmpty()) {
            filteredArrayList.addAll(peopleListFiltered)

        } else {
            var searchChar = text.toString().toLowerCase()

            for (people in peopleListFiltered) {
                if (people.name.toLowerCase().contains(searchChar)) {
                    filteredArrayList.add(people)
                }
            }

            peopleAdapter.setFilteredList(filteredArrayList)

        }*/

    }


    fun getFilter(text: String): Filter {
        val filter = object : Filter() {

            var peopleListFiltered = ArrayList<PeopleModel>()

            override fun performFiltering(p0: CharSequence?): FilterResults {

                var filterResults = FilterResults()
                var filteredArrayList = ArrayList<PeopleModel>()

                if (p0 == null || p0.isEmpty()) {
                    /*filteredArrayList.addAll(peopleListFiltered)*/
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
            }
        }
        return filter
    }


    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        if (id == R.id.search_action) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.menu_people_app_bar, menu)
        val item = menu.findItem(R.id.search_action)
        val searchView = item.actionView as SearchView


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchText: String? = newText
                peopleAdapter.filter.filter(searchText)
                return true
            }

        })

        super.onCreateOptionsMenu(menu, inflater)
    }
*/

}