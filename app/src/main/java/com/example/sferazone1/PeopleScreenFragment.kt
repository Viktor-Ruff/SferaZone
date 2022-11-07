package com.example.sferazone1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.sferazone1.adapters.peopleAdapters.PeoplePagerAdapter
import com.example.sferazone1.databinding.FragmentPeopleScreenBinding
import com.example.sferazone1.model.UserService
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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
        navController = findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.appBarPeople.setupWithNavController(navController, appBarConfiguration)

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

}