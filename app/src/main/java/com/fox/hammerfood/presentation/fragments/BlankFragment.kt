package com.fox.hammerfood.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fox.hammerfood.R
import com.fox.hammerfood.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {
    private lateinit var binding: FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater)
        return binding.root
    }
}