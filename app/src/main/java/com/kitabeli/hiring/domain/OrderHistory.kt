package com.kitabeli.hiring.domain

data class OrderHistory(
    val orderId: Long,
    val updatedAt: String,
    val orderItems: List<OrderItem>
)
