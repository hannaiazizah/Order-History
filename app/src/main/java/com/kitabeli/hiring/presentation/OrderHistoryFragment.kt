package com.kitabeli.hiring.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kitabeli.hiring.data.OrderStatus
import com.kitabeli.hiring.databinding.FragmentOrderHistoryBinding

class OrderHistoryFragment: Fragment() {
    private var _binding: FragmentOrderHistoryBinding? = null
    private val binding: FragmentOrderHistoryBinding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOrderHistoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ORDER_STATUS = "ORDER_STATUS"
        fun instantiate(orderStatus: OrderStatus): OrderHistoryFragment {
            val fragment = OrderHistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ORDER_STATUS, orderStatus.status)
                }
            }
            return fragment
        }
    }
}