package com.example.fakecommerce2.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.fakecommerce2.R
import com.example.fakecommerce2.base.BaseFragment
import com.example.fakecommerce2.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),HomeAdapter.Listener {

  val viewModel: HomeViewModel by activityViewModels()

    val adapter:HomeAdapter by lazy {
        HomeAdapter(this@HomeFragment)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allProductResponse.observe(viewLifecycleOwner){

            adapter.submitList(it)
            binding.product1.adapter=adapter

        }

    }

    override fun itemClick(id: Int) {

        viewModel.getProductById(id)


    }


}