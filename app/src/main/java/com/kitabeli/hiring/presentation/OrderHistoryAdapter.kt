package com.kitabeli.hiring.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.kitabeli.hiring.R
import com.kitabeli.hiring.presentation.model.OrderHistoryUi

class OrderHistoryAdapter: PagingDataAdapter<OrderHistoryUi, OrderHistoryViewHolder>(DIFF_CALLBACK) {
    override fun onBindViewHolder(holder: OrderHistoryViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_history_item, parent, false)
        return OrderHistoryViewHolder(view)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<OrderHistoryUi>() {
            override fun areItemsTheSame(oldItem: OrderHistoryUi, newItem: OrderHistoryUi): Boolean {
                return oldItem.orderId == newItem.orderId
            }

            override fun areContentsTheSame(oldItem: OrderHistoryUi, newItem: OrderHistoryUi): Boolean =
                oldItem == newItem
        }
    }
}