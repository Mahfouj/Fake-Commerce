package com.example.fakecommerce2.data.cart


import com.google.gson.annotations.SerializedName

data class ResponeCartItem(
    @SerializedName("date")
    var date: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("products")
    var products: List<Product?>?,
    @SerializedName("userId")
    var userId: Int?,
    @SerializedName("__v")
    var v: Int?
)