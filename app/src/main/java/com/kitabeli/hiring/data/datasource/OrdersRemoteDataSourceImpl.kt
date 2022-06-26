package com.kitabeli.hiring.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kitabeli.hiring.data.remote.OrderService
import com.kitabeli.hiring.data.remote.OrdersPagingSource
import com.kitabeli.hiring.data.remote.OrdersRemoteDataSource
import com.kitabeli.hiring.domain.OrderHistory
import kotlinx.coroutines.flow.Flow

class OrdersRemoteDataSourceImpl(
    private val orderService: OrderService
) : OrdersRemoteDataSource {
    override fun getOrderHistory(orderStatus: String): Flow<PagingData<OrderHistory>> {
        return Pager(
            config = PagingConfig(
                pageSize = OrdersPagingSource.PAGE_LIMIT,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                OrdersPagingSource(
                    service = orderService,
                    status = orderStatus
                )
            }
        ).flow
    }
}