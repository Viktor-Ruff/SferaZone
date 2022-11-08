package com.example.sferazone1

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.sferazone1.PeopleAdapters.SubscribersAdapter
import com.example.sferazone1.adapters.PeopleAdapter
import com.example.sferazone1.databinding.FragmentPeopleScreenBinding
import com.example.sferazone1.model.PeopleModel
import com.example.sferazone1.model.UserService


class PeopleScreenFragment : Fragment(), SubscribersAdapter.ClickListener {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: FragmentPeopleScreenBinding
    private lateinit var subscribersAdapter:SubscribersAdapter
    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people_screen, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding = FragmentPeopleScreenBinding.bind(view)

        initNavigation()
        initRecycler()


       /* binding.peopleRecycler.adapter = PeopleAdapter(userService.initPeopleList())*/





    }

    private fun initRecycler(){
        val userService = UserService()
        subscribersAdapter = SubscribersAdapter(this)
        subscribersAdapter.setData(userService.initPeopleList())
        binding.peopleRecycler.adapter = subscribersAdapter

    }

    private fun initNavigation(){
        toolbar = binding.toolbarPeople

        navController = findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbarPeople.setupWithNavController(navController, appBarConfiguration)
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
                subscribersAdapter.filter.filter(newText)
                return true
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun clickedItem(people: PeopleModel) {
        TODO("Not yet implemented")
    }

}