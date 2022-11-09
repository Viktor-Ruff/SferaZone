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

    private lateinit var subscribersList: List<PeopleModel>
    private lateinit var subscriptionList: List<PeopleModel>
    private lateinit var mutuallyList: List<PeopleModel>
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: FragmentPeopleScreenBinding
    private lateinit var listFragments: List<Fragment>
    private lateinit var subscribersAdapter: PeopleAdapter
    private lateinit var subscriptionAdapter: PeopleAdapter
    private lateinit var mutuallyAdapter: PeopleAdapter
    private lateinit var subscribersFilter: ListFilter
    private lateinit var subscriptionFilter: ListFilter
    private lateinit var mutuallyFilter: ListFilter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_people_screen, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPeopleScreenBinding.bind(view)

        initAdapters()
        initList()
        initFilter()
        initFragments()
        initNavigation()
        initViewPager2()
        initSearch()
    }

    private fun initAdapters() {
        subscribersAdapter = PeopleAdapter(this)
        subscriptionAdapter = PeopleAdapter(this)
        mutuallyAdapter = PeopleAdapter(this)
    }


    private fun initList() {
        val userService = UserService()
        subscribersList = userService.initPeopleList(40)
        subscriptionList = userService.initPeopleList(10)
        mutuallyList = userService.initPeopleList(5)
    }


    private fun initFilter() {
        subscribersFilter = ListFilter(subscribersAdapter, subscribersList)
        subscriptionFilter = ListFilter(subscriptionAdapter, subscriptionList)
        mutuallyFilter = ListFilter(mutuallyAdapter, mutuallyList)
    }


    private fun initFragments() {

        listFragments = listOf(
            ListFragment(subscribersAdapter, subscribersList),
            ListFragment(subscriptionAdapter, subscriptionList),
            ListFragment(mutuallyAdapter, mutuallyList)
        )
    }


    private fun initNavigation() {
        navController = findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbarPeople.setupWithNavController(navController, appBarConfiguration)
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
        /* findNavController().navigate(R.id.action_peopleScreenFragment_to_selectedUserScreenFragment)*/
    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (newText != null) {
            subscribersFilter.filterList(newText)
            subscriptionFilter.filterList(newText)
            mutuallyFilter.filterList(newText)
        }

        return true
    }

}