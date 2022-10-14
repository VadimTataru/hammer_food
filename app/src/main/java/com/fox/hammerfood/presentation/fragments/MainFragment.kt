package com.fox.hammerfood.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.fox.hammerfood.databinding.FragmentMainBinding
import com.fox.hammerfood.presentation.adapter.FoodListAdapter
import com.fox.hammerfood.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var foodListAdapter: FoodListAdapter
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getFood()
        initRecyclerView()
        viewModel.getFoodList().observe(viewLifecycleOwner) {
            if(!it.isNullOrEmpty())
                foodListAdapter.addItems(it)
        }
    }

    private fun initRecyclerView() {
        binding.rcView.apply {
            foodListAdapter = FoodListAdapter()
            adapter = foodListAdapter
        }
    }
}