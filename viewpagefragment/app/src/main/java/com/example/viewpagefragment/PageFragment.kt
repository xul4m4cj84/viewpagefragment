package com.example.viewpagefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagefragment.databinding.FragmentLayoutBinding

private const val ARG_PARAM1 = "param1"

class PageFragment : Fragment(){
    private var cityName: String? = null
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            cityName = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLayoutBinding>(inflater, R.layout.fragment_layout, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)

        val layoutManager = LinearLayoutManager(this.activity)
        binding.recyclerView.layoutManager = layoutManager

        val citySceneList = viewModel.sceneList.filter{ it.city == cityName }
        val adapter = RecyclerViewAdapter(citySceneList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this.activity,
                DividerItemDecoration.VERTICAL
            )
        )
        return binding.root
    }

    companion object {
        @JvmStatic

        fun newInstance(cityName: String) =
            PageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, cityName)
                }
            }
    }
}
