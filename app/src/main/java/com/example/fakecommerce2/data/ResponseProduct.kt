package com.example.fakecommerce2.data


import com.google.gson.annotations.SerializedName

data class ResponseProduct(
    @SerializedName("category")
    var category: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("image")
    var image: String?,
    @SerializedName("price")
    var price: Double?,
    @SerializedName("rating")
    var rating: Rating?,
    @SerializedName("title")
    var title: String?
)