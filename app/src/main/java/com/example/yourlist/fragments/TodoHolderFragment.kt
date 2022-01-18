package com.example.yourlist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yourlist.R
import com.example.yourlist.adapters.RecyclerAdapter
import com.example.yourlist.data.DataHolder
import com.example.yourlist.databinding.FragmentTodoHolderBinding


class TodoHolderFragment : Fragment() {
    private lateinit var binding: FragmentTodoHolderBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todo_holder, container, false)
        binding = FragmentTodoHolderBinding.bind(view)

        layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = layoutManager
        adapter = RecyclerAdapter()
        binding.recyclerView.adapter = adapter

        binding.btnDone.setOnClickListener{
            DataHolder.mainActivity.changeFragment(MainFragment())
        }

        return view
    }






}