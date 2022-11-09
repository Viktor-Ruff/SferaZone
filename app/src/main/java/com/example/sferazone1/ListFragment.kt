package com.example.sferazone1


import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.sferazone1.adapters.peopleAdapters.PeopleAdapter
import com.example.sferazone1.databinding.FragmentListBinding
import com.example.sferazone1.model.PeopleModel
import com.example.sferazone1.model.UserService


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