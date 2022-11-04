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
import com.example.sferazone1.adapters.PeopleAdapter
import com.example.sferazone1.databinding.FragmentPeopleScreenBinding
import com.example.sferazone1.model.UserService


class PeopleScreenFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: FragmentPeopleScreenBinding


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

        val userService = UserService()
        binding = FragmentPeopleScreenBinding.bind(view)
        binding.peopleRecycler.adapter = PeopleAdapter(userService.initPeopleList())
        navController = findNavController()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.appBarPeople.setupWithNavController(navController, appBarConfiguration)

    }

}