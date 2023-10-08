package com.example.fakecommerce2.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fakecommerce2.data.cart.Product
import com.example.fakecommerce2.databinding.ProductCartBinding

class CartAdapter : ListAdapter<Product, CartAdapter.VH>(Comparator) {

    class VH(val binding: ProductCartBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {

        val Comparator = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(
                oldItem: Product,
                newItem: Product
            ): Boolean {

                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: Product,
                newItem: Product
            ): Boolean {
                return oldItem.productId == newItem.productId
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ProductCartBinding .inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position).let { cart ->

            holder.binding.productNameTextView.text = "${cart?.productId}"
            holder.binding.quantityTextView.text = "${cart?.quantity}"

        }
    }
}