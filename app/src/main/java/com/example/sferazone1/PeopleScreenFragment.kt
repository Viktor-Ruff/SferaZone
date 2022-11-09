package com.example.sferazone1

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.sferazone1.adapters.peopleAdapters.PeoplePagerAdapter
import com.example.sferazone1.databinding.FragmentPeopleScreenBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.example.sferazone1.adapters.peopleAdapters.PeopleAdapter
import com.example.sferazone1.model.PeopleModel
import com.example.sferazone1.model.UserService

private const val ZERO: Int = 0
private const val ONE: Int = 1
private const val TWO: Int = 2

class PeopleScreenFragment : Fragment(), PeopleAdapter.ClickListener,
    SearchView.OnQueryTextListener {

    private var peopleListFiltered: List<PeopleModel> = arrayListOf()
    private lateinit var peopleList: List<PeopleModel>
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: FragmentPeopleScreenBinding
    private lateinit var listFragments: List<Fragment>
    private lateinit var peopleAdapter: PeopleAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people_screen, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPeopleScreenBinding.bind(view)
        peopleAdapter = PeopleAdapter(this)

        initLists()
        initNavigation()
        initViewPager2()
        initSearch()
    }


    private fun initLists() {
        val userService = UserService()
        peopleList = userService.initPeopleList(40)
        peopleListFiltered = peopleList
        listFragments = listOf(
            ListFragment(peopleAdapter, peopleList),
            ListFragment(peopleAdapter, peopleList),
            ListFragment(peopleAdapter, peopleList)
        )
    }


    private fun initViewPager2() {
        val viewPager = binding.viewPager
        val tabLayout: TabLayout = binding.tabLayout
        viewPager.adapter = PeoplePagerAdapter(requireActivity(), listFragments)
        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            when (pos) {
                ZERO -> tab.setText(R.string.subscribers)

                ONE -> tab.setText(R.string.subscriptions)

                TWO -> tab.setText(R.string.mutually)
            }
        }.attach()
    }


    private fun initNavigation() {
        navController = findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbarPeople.setupWithNavController(navController, appBarConfiguration)
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
        peopleAdapter.setFilteredList(filteredArrayList)
    }


    private fun initSearch() {
        binding.toolbarPeople.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search_action -> {
                    val searchView = it.actionView as SearchView
                    searchView.queryHint = context?.getString(R.string.search)
                    searchView.setIconifiedByDefault(false)
                    searchView.clearFocus()


                    val ll = searchView.getChildAt(0) as LinearLayout
                    val ll2 = ll.getChildAt(2) as LinearLayout
                    val ll3 = ll2.getChildAt(1) as LinearLayout
                    val autoComplete = ll3.getChildAt(0) as SearchView.SearchAutoComplete
                    autoComplete.setHintTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.main_color1
                        )
                    )
                    autoComplete.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.main_color
                        )
                    )

                    searchView.setOnQueryTextListener(this)
                }
            }
            true
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

}