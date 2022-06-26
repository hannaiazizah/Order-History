package com.kitabeli.hiring.data.repository

import androidx.paging.PagingData
import com.kitabeli.hiring.domain.OrderHistory
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    fun getOrderHistory(orderStatus: String): Flow<PagingData<OrderHistory>>
}