package com.example.sferazone1

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
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


class ListFragment : Fragment(), PeopleAdapter.ClickListener, SubscribersAdapter.ClickListener {

    private var paramName: String? = null
    private var param1: Int = 0


    private lateinit var subscribersAdapter: SubscribersAdapter
    private lateinit var binding: FragmentListBinding


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


        /* val peopleAdapter = PeopleAdapter()
         peopleAdapter.submitList(userService.initPeopleList(param1))
         binding.peopleRecycler.adapter = peopleAdapter*/

        subscribersAdapter = SubscribersAdapter(this)
        subscribersAdapter.setData(userService.initPeopleList(param1))
        binding.peopleRecycler.adapter = subscribersAdapter

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

    override fun clickedItem() {
        findNavController().navigate(R.id.action_peopleScreenFragment_to_selectedUserScreenFragment)


    }

    override fun clickedItem(people: PeopleModel) {
        findNavController().navigate(R.id.action_peopleScreenFragment_to_selectedUserScreenFragment)

    }


    /*override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.menu_people_app_bar, menu)
        val item = menu.findItem(R.id.search_action)
        val searchView = item.actionView as SearchView


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                subscribersAdapter.filter.filter(newText)
                return true
            }

        })


        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }*/





}