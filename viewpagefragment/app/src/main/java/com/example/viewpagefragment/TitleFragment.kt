package com.example.viewpagefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewpagefragment.databinding.FragmentTitleBinding
import com.google.android.material.tabs.TabLayoutMediator


class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title, container, false)
        val viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        binding.viewPager.adapter = FragmentAdapter(requireActivity(), viewModel.cityList)

        TabLayoutMediator(binding.tabs, binding.viewPager){ tab, position-> tab.text = viewModel.cityList[position] }.attach()

        return binding.root
    }
}