package com.kitabeli.hiring.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kitabeli.hiring.R
import com.kitabeli.hiring.presentation.model.OrderHistoryUi

class OrderHistoryViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView) {
    private val itemAdapter by lazy { OrderItemAdapter() }
    private val orderList: RecyclerView = itemView.findViewById(R.id.list_order)
    private val orderView: TextView = itemView.findViewById(R.id.txt_order_history_id)
    private val dateView: TextView = itemView.findViewById(R.id.txt_order_history_date)

    fun bind(orderHistoryUi: OrderHistoryUi) {
        orderList.adapter = itemAdapter
        itemAdapter.submitData(orderHistoryUi.items)
        orderView.text = itemView.context.getString(R.string.txt_order_id, orderHistoryUi.orderId)
        dateView.text = orderHistoryUi.date
    }
}