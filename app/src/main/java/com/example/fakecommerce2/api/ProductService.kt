package com.example.fakecommerce2.api

import com.example.fakecommerce2.data.ResponseProduct
import com.example.fakecommerce2.data.cart.ResponeCart
import com.example.fakecommerce2.data.cart.ResponeCartItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    suspend  fun getAllProduct(): Response<List<ResponseProduct>>

    @GET("products/{id}")
    suspend  fun getProductById(
        @Path("id")id:Int
    ): Response<ResponseProduct>



    @GET("carts/user/{id}")
    suspend  fun getAllCart(@Path("id")id:Int): Response<List<ResponeCartItem>>
}