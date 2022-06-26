package com.kitabeli.hiring.domain

data class OrderItem(
    val quantity: Long,
    val itemName: String,
    val totalItemAmount: Long
)