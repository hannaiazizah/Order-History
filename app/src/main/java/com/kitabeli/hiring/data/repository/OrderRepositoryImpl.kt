package com.kitabeli.hiring.data.repository

import androidx.paging.PagingData
import com.kitabeli.hiring.data.remote.OrdersRemoteDataSource
import com.kitabeli.hiring.domain.OrderHistory
import kotlinx.coroutines.flow.Flow

class OrderRepositoryImpl(
    private val remoteDataSource: OrdersRemoteDataSource
): OrderRepository {
    override fun getOrderHistory(orderStatus: String): Flow<PagingData<OrderHistory>> {
        return remoteDataSource.getOrderHistory(orderStatus)
    }
}