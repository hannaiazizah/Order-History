package com.kitabeli.hiring.presentation

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kitabeli.hiring.domain.OrderStatus

class OrderCollectionPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount() = FRAGMENT_SIZE

    override fun createFragment(position: Int): Fragment {
        return OrderHistoryFragment.instantiate(getOrderStatus(position))
    }

    private fun getOrderStatus(position: Int): OrderStatus {
        return when (position) {
            0 -> OrderStatus.CONFIRMED
            1 -> OrderStatus.DISPATCHED
            2 -> OrderStatus.COMPLETED
            3 -> OrderStatus.CANCELLED
            else -> OrderStatus.CONFIRMED
        }
    }

    companion object {
        const val FRAGMENT_SIZE = 4
    }
}