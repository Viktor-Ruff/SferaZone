package com.example.sferazone1.view.screens


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.sferazone1.R
import com.example.sferazone1.view.peopleAdapters.PeopleAdapter
import com.example.sferazone1.databinding.FragmentListBinding
import com.example.sferazone1.model.PeopleModel


class ListFragment(peopleAdapter: PeopleAdapter, peopleList: List<PeopleModel>) : Fragment() {

    private var peopleList: List<PeopleModel>
    private var peopleAdapter: PeopleAdapter

    private lateinit var binding: FragmentListBinding

    init {
        this.peopleList = peopleList
        this.peopleAdapter = peopleAdapter
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        peopleAdapter.submitList(peopleList.toMutableList())
        binding.peopleRecycler.adapter = peopleAdapter
    }
}