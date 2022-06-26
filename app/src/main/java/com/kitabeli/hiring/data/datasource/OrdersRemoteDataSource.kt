package com.kitabeli.hiring.data.remote

import androidx.paging.PagingData
import com.kitabeli.hiring.domain.OrderHistory
import kotlinx.coroutines.flow.Flow

interface OrdersRemoteDataSource {
    fun getOrderHistory(orderStatus: String): Flow<PagingData<OrderHistory>>
}
