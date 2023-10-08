package com.example.fakecommerce2.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.fakecommerce2.data.ResponseProduct
import com.example.fakecommerce2.databinding.Product2Binding
import com.example.fakecommerce2.databinding.ProductRecomendedBinding

class HomeAdapter(private val listener: Listener):ListAdapter<ResponseProduct,HomeAdapter.Vh>(COMPARATOR){

    interface  Listener{

        fun itemClick(id:Int)
    }


    class Vh(val binding: ProductRecomendedBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {

            return  Vh(ProductRecomendedBinding.inflate(LayoutInflater.
            from(parent.context),
            parent,false)  )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {

        getItem(position).let {
            holder.binding.apply {
                     reImg.load(it.image)
                     textView.text=it.title
                     price.text="$${it.price}"
                     textView3.text=it.description
                     textView6.text=it.category
                     textView4.text="(${it.rating?.rate})"
                     textView5.text="${it.rating?.count}"


          holder.itemView.setOnClickListener {

              listener.itemClick(it.id)
          }
            }
        }




    }


    companion object{


        var COMPARATOR =object:DiffUtil.ItemCallback<ResponseProduct>(){
            override fun areItemsTheSame(
                oldItem: ResponseProduct,
                newItem: ResponseProduct
            ): Boolean {
                 return oldItem==newItem
            }

            override fun areContentsTheSame(
                oldItem: ResponseProduct,
                newItem: ResponseProduct
            ): Boolean {

                return oldItem.id==newItem.id
            }


        }
    }





}