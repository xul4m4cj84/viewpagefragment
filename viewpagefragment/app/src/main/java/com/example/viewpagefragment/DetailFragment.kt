package com.example.viewpagefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewpagefragment.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false)

        val viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        val args = DetailFragmentArgs.fromBundle(requireArguments())

        binding.scene = viewModel.sceneList[args.sceneIndex]

        return binding.root
    }
}
