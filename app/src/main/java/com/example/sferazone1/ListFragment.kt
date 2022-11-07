package com.example.sferazone1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sferazone1.adapters.peopleAdapters.SubscribersAdapter
import com.example.sferazone1.databinding.FragmentListBinding
import com.example.sferazone1.model.PeopleModel
import com.example.sferazone1.model.UserService


private const val ARG_PARAM1 = "param1"


class ListFragment : Fragment() {

    private var param1: Int = 0

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
        }

        binding = FragmentListBinding.bind(view)
        val userService = UserService()


        val subscribersAdapter = SubscribersAdapter(userService.initPeopleList(param1))
        binding.peopleRecycler.adapter = subscribersAdapter

    }

    companion object {


        @JvmStatic
        fun newInstance(param1: Int) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)

                }
            }
    }
}