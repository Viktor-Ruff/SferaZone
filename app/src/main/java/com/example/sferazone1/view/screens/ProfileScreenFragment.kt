package com.example.sferazone1.view.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.sferazone1.R
import com.example.sferazone1.view.profileAdapters.ChroniclesAdapter
import com.example.sferazone1.view.profileAdapters.MomentsAdapter
import com.example.sferazone1.view.profileAdapters.UserImagesAdapter
import com.example.sferazone1.databinding.FragmentProfileScreenBinding
import com.example.sferazone1.viewModel.UserService


class ProfileScreenFragment : Fragment() {

    private lateinit var binding: FragmentProfileScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_screen, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProfileScreenBinding.bind(view)

        binding.textInputEditText.setOnFocusChangeListener { view, b ->
            binding.textInputLayout.counterTextColor =
                getColorStateList(requireContext(), R.color.second_color)
        }

        binding.btPeople.setOnClickListener {
            findNavController().navigate(R.id.action_profileScreenFragment_to_peopleScreenFragment)
        }

        headerProfile()
        realisationUserRecyclers()
    }


    private fun headerProfile() {
        Glide
            .with(this)
            .load("https://s.kaskus.id/images/2020/08/24/10465325_202008241120270053.jpg")
            .into(binding.profileImage)
    }


    private fun realisationUserRecyclers() {

        val userService = UserService()

        binding.userImagesRecycler.adapter = UserImagesAdapter(userService.initImagesUserLIst())
        binding.userImagesRecycler.stopScroll()

        binding.userMomentsRecycler.adapter = MomentsAdapter(userService.initMomentsList())

        binding.userChroniclesRecycler.layoutManager =
            GridLayoutManager(requireActivity().baseContext, 3, GridLayoutManager.VERTICAL, false)
        binding.userChroniclesRecycler.adapter = ChroniclesAdapter(userService.initChroniclesList())
        binding.userChroniclesRecycler.stopScroll()
    }

}