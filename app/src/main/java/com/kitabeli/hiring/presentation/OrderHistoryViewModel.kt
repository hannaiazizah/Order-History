package com.kitabeli.hiring.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.kitabeli.hiring.data.repository.OrderRepository
import com.kitabeli.hiring.presentation.model.OrderHistoryUi
import com.kitabeli.hiring.presentation.model.toOrderHistoryUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OrderHistoryViewModel(
    private val orderRepository: OrderRepository
): ViewModel() {
    fun getOrderHistory(orderStatus: String): Flow<PagingData<OrderHistoryUi>> {
        return orderRepository.getOrderHistory(orderStatus)
            .map { paging ->
                paging.map {
                    it.toOrderHistoryUi()
                }
            }
            .cachedIn(viewModelScope)
    }
}