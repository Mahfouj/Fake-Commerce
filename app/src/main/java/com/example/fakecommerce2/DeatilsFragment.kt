package com.example.fakecommerce2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.fakecommerce2.base.BaseFragment
import com.example.fakecommerce2.databinding.FragmentDeatilsBinding
import com.example.fakecommerce2.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DeatilsFragment :BaseFragment<FragmentDeatilsBinding>(FragmentDeatilsBinding::inflate){

    private val viewModel:HomeViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        viewModel.ProductResponse.observe(viewLifecycleOwner) {
//            binding.apply {
//
//                reImg.load(it.image)
//                textView.text = it.title
//                price.text = "$${it.price}"
//                textView3.text = it.description
//                textView6.text = it.category
//                textView4.text = "(${it.rating?.rate})"
//                textView5.text = "${it.rating?.count}"
//            }
//        }
    }
}