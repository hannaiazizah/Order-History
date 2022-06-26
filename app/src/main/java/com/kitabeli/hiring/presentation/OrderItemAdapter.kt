package com.kitabeli.hiring.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kitabeli.hiring.R
import com.kitabeli.hiring.presentation.model.OrderItemUi

class OrderItemAdapter : RecyclerView.Adapter<OrderItemAdapter.ViewHolder>() {

    private val items = mutableListOf<OrderItemUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitData(data: List<OrderItemUi>) {
        val diffCallback = OrderItemDiffUtil(items, data)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(data)
        diffResult.dispatchUpdatesTo(this)
    }

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView = itemView.findViewById(R.id.img_order_item)
        val titleView: TextView = itemView.findViewById(R.id.txt_order_item_name)
        val priceView: TextView = itemView.findViewById(R.id.txt_order_item_price)
        val quantityView: TextView = itemView.findViewById(R.id.txt_order_item_qty)
        val labelView: TextView = itemView.findViewById(R.id.txt_order_item_status_label)

        fun bind(orderItemUi: OrderItemUi) {
            Glide.with(itemView.context)
                .load(orderItemUi.imgUrl)
                .fitCenter()
                .into(imgView)
            titleView.text = orderItemUi.itemName
            priceView.text = itemView.context.getString(R.string.item_price, orderItemUi.price)
            quantityView.text = itemView.context.getString(R.string.item_quantity, orderItemUi.quantity)
            labelView.isVisible =
                orderItemUi.labelText != 0 && orderItemUi.labelBackground != 0 && orderItemUi.labelColor != 0
            labelView.text = itemView.context.getString(orderItemUi.labelText)
            labelView.background = AppCompatResources.getDrawable(itemView.context, orderItemUi.labelBackground)
            labelView.setTextColor(orderItemUi.labelColor)
        }
    }

    class OrderItemDiffUtil(
        private val oldList: List<OrderItemUi>,
        private val newList: List<OrderItemUi>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            newList[newItemPosition].itemId == oldList[oldItemPosition].itemId

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            newList[newItemPosition] == oldList[oldItemPosition]
    }
}