package com.kitabeli.hiring.presentation.model

import com.kitabeli.hiring.R
import com.kitabeli.hiring.common.toFormattedPrice
import com.kitabeli.hiring.domain.ItemStatus
import com.kitabeli.hiring.domain.OrderItem

data class OrderItemUi (
    val itemId: Long,
    val quantity: String,
    val itemName: String,
    val price: String,
    val imgUrl: String,
    val labelText: Int,
    val labelBackground: Int,
    val labelColor: Int
)

fun OrderItem.toOrderUi(): OrderItemUi = OrderItemUi(
    itemId = itemId,
    quantity = quantity.toString(),
    itemName = itemName,
    price = totalItemAmount.toFormattedPrice(),
    imgUrl = itemImgUrl,
    labelText = getStatusLabelText(status),
    labelBackground = getStatusLabelBackground(status),
    labelColor = getStatusLabelColor(status)
)

fun getStatusLabelText(itemStatus: ItemStatus): Int {
    return when (itemStatus) {
        ItemStatus.NONE -> 0
        ItemStatus.CANCELLED -> R.string.item_cancelled
        ItemStatus.DELIVERED -> R.string.item_delivered
        ItemStatus.PACKED -> R.string.item_packed
    }
}

fun getStatusLabelBackground(itemStatus: ItemStatus): Int {
    return when(itemStatus) {
        ItemStatus.DELIVERED, ItemStatus.PACKED -> R.drawable.bg_rounded_green
        ItemStatus.CANCELLED -> R.drawable.bg_rounded_orange
        else -> 0
    }
}

fun getStatusLabelColor(itemStatus: ItemStatus): Int {
    return when(itemStatus) {
        ItemStatus.DELIVERED, ItemStatus.PACKED -> R.color.green
        ItemStatus.CANCELLED -> R.color.orange
        else -> 0
    }
}