package com.example.fakecommerce2.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakecommerce2.data.ResponseProduct
import com.example.fakecommerce2.data.cart.ResponeCartItem
import com.example.fakecommerce2.repos.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.IdentityHashMap
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val repo: ProductRepo): ViewModel() {

    private val _allCartResponse= MutableLiveData<List<ResponeCartItem>>()

    val allCartResponse: LiveData<List< ResponeCartItem>>
        get() =  _allCartResponse

    init {
        getAllCart()

    }

    private fun getAllCart() {

        viewModelScope.launch {

            val response=repo. getAllCart()
            if (response.isSuccessful) {

                _allCartResponse.postValue(response.body())
            }
        }
    }



}