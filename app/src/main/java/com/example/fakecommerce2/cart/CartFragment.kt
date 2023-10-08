package com.example.fakecommerce2.cart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.fakecommerce2.base.BaseFragment
import com.example.fakecommerce2.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment :BaseFragment<FragmentCartBinding>(FragmentCartBinding::inflate) {

    private val viewModel : CartViewModel by viewModels()

    private val adapter: CartAdapter by  lazy {

        CartAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.allCartResponse.observe(viewLifecycleOwner) {
         adapter.submitList(it[0].products)
         binding.CartRCV.adapter = adapter
        }

    }

}