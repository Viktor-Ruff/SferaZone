package com.example.sferazone1.view.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sferazone1.R
import com.example.sferazone1.databinding.FragmentSelectedUserScreenBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SelectedUserScreenFragment : Fragment() {

    lateinit var binding:FragmentSelectedUserScreenBinding

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selected_user_screen, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSelectedUserScreenBinding.bind(view)
        getData()
    }


    fun initData(){
        binding.userName
    }


    private fun getData() {
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectedUserScreenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}