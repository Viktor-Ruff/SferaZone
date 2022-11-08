package com.example.sferazone1

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import androidx.appcompat.widget.DecorToolbar
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
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.sferazone1.model.PeopleModel

private const val ZERO: Int = 0
private const val ONE: Int = 1
private const val TWO: Int = 2

class PeopleScreenFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: FragmentPeopleScreenBinding



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
        initViewPager2()

    }


    private fun initViewPager2() {
        val viewPager = binding.viewPager
        val tabLayout: TabLayout = binding.tabLayout
        val listFragments: List<Fragment> = listOf(
            ListFragment.newInstance(40),
            ListFragment.newInstance(8),
            ListFragment.newInstance(3)
        )


        viewPager.adapter = PeoplePagerAdapter(requireActivity(), listFragments)
        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            when (pos) {
                ZERO -> tab.setText(R.string.subscribers)

                ONE -> tab.setText(R.string.subscriptions)

                TWO -> tab.setText(R.string.mutually)
            }
        }.attach()
    }


    private fun initNavigation(){
        navController = findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.appBarPeople.setupWithNavController(navController, appBarConfiguration)
    }


    private fun setupListeners() {

        binding.appBarPeople.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.search_action -> {
                    val searchView = it.actionView as SearchView
                    searchView.queryHint = context?.getString(R.string.search)
                    searchView.setIconifiedByDefault(false)

                    val ll = searchView.getChildAt(0) as LinearLayout
                    val ll2 = ll.getChildAt(2) as LinearLayout
                    val ll3 = ll2.getChildAt(1) as LinearLayout
                    Log.d("EEE", ll3.childCount.toString())
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
                            R.color.second_color
                        )
                    )

                    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                        override fun onQueryTextSubmit(query: String?): Boolean {
                            return false
                        }

                        override fun onQueryTextChange(newText: String?): Boolean {
                            /*subscribersAdapter.filter.filter(newText)*/
                            return false
                        }
                    })
                }
            }
            true
        }
    }

}