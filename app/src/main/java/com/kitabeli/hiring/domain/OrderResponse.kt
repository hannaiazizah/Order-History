package com.kitabeli.hiring.domain

import com.google.gson.annotations.SerializedName

data class OrderResponse(
    @SerializedName("data") val data: OrderList
)

data class OrderList(
    @SerializedName("ordersResponseDTO") val orders: List<OrderHistory>
)