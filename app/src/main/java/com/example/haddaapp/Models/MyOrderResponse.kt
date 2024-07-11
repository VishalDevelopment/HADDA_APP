package com.example.haddaapp.Models

data class MyOrderResponse(
    val address: String,
    val category: String,
    val email: String,
    val id: Int,
    val name: String,
    val orderDate: String,
    val orderTiming: String,
    val phone_no: String,
    val price: Double,
    val status: String,
    val unit: Int,
    val userID: String,
    val weight: Double
)