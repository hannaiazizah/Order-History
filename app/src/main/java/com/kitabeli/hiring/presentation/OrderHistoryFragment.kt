package com.kitabeli.hiring.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.kitabeli.hiring.domain.OrderStatus
import com.kitabeli.hiring.databinding.FragmentOrderHistoryBinding
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderHistoryFragment: Fragment() {
    private var _binding: FragmentOrderHistoryBinding? = null
    private val binding: FragmentOrderHistoryBinding get() = _binding!!
    private val viewModel by viewModel<OrderHistoryViewModel>()
    private val adapter by lazy { OrderHistoryAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentOrderHistoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val status = arguments?.getString(ORDER_STATUS) ?: OrderStatus.CONFIRMED.status
        binding.listHistory.adapter = adapter
        collectData(status)
    }

    private fun collectData(status: String) {
        lifecycleScope.launchWhenResumed {
            viewModel.getOrderHistory(status).collectLatest {
                adapter.submitData(it)
            }
        }
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