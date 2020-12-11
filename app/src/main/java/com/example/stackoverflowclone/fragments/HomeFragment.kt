package com.example.stackoverflowclone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stackoverflowclone.R
import com.example.stackoverflowclone.activities.MainActivity
import com.example.stackoverflowclone.databinding.FragmentHomeBinding
import com.example.stackoverflowclone.rv.RvItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    //    private lateinit var binding: HomeFragmentBinding
    private var adapter: GroupAdapter<GroupieViewHolder>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        binding.btnAsqQuestion.text = "Ask Question"

        adapter = GroupAdapter()
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        adapter!!.add(RvItem(activity as MainActivity, "Title"))
        rvItem.layoutManager = LinearLayoutManager(activity)
        rvItem.adapter = adapter


    }

}