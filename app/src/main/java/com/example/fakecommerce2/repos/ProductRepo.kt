package com.example.fakecommerce2.repos

import com.example.fakecommerce2.api.ProductService
import com.example.fakecommerce2.data.ResponseProduct
import com.example.fakecommerce2.data.cart.ResponeCartItem
import retrofit2.Response
import javax.inject.Inject

class ProductRepo @Inject constructor(private val service:ProductService){

    suspend fun getAllProduct(): Response<List<ResponseProduct>> {
        return service.getAllProduct()

}
    suspend fun getAllProductById(id:Int): Response<ResponseProduct> {
        return service.getProductById(id)

    }

    suspend fun getAllCart(
    ): Response<List<ResponeCartItem>> {
        return service.getAllCart(2)
    }
}