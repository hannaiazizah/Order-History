package com.kitabeli.hiring.presentation.model

import com.kitabeli.hiring.common.getFormattedDate
import com.kitabeli.hiring.domain.OrderHistory

data class OrderHistoryUi(
    val date: String,
    val orderId: Long,
    val items: List<OrderItemUi>
)

fun OrderHistory.toOrderHistoryUi() = OrderHistoryUi(
    date = updatedAt.getFormattedDate(),
    orderId = orderId,
    items = orderItems.map {
        it.toOrderUi()
    }
)
