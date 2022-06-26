package com.kitabeli.hiring.domain

data class OrderItem(
    val itemId: Long,
    val quantity: Long,
    val itemName: String,
    val totalItemAmount: Long,
    val status: ItemStatus,
    val itemImgUrl: String
)