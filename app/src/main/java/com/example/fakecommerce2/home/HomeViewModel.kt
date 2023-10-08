package com.example.fakecommerce2.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakecommerce2.data.ResponseProduct
import com.example.fakecommerce2.repos.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.IdentityHashMap
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: ProductRepo): ViewModel() {

    private val _allProductResponse= MutableLiveData<List<ResponseProduct>>()

    val allProductResponse: LiveData<List<ResponseProduct>>
        get() =_allProductResponse

    init {
        getAllProduct()

    }

    private fun getAllProduct() {

        viewModelScope.launch {

            val response=repo.getAllProduct()
            if (response.isSuccessful) {

                _allProductResponse.postValue(response.body())
            }
        }
    }

    private val _ProductResponse= MutableLiveData<ResponseProduct>()

    val ProductResponse: LiveData<ResponseProduct>
        get() =_ProductResponse

      fun getProductById(id:Int){

          viewModelScope.launch {

              var response = repo.getAllProductById(id)

              if (response.isSuccessful) {

            _ProductResponse.postValue(response.body())
              }
          }
      }

}