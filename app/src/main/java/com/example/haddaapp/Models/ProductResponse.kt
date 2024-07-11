package com.example.haddaapp.Models

data class ProductResponse(
    var Unit: Int,
    val category: String,
    val id: Int,
    var price: Double,
    val status: String
)