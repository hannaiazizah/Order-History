package com.kitabeli.hiring.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.kitabeli.hiring.R
import com.kitabeli.hiring.databinding.FragmentOrderCollectionBinding

class OrderCollectionFragment : Fragment() {
    private var _binding: FragmentOrderCollectionBinding? = null
    private val binding: FragmentOrderCollectionBinding get() = _binding!!

    private val pagerAdapter by lazy { OrderCollectionPagerAdapter(this@OrderCollectionFragment) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentOrderCollectionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> getString(R.string.order_confirmed)
            1 -> getString(R.string.order_dispatch)
            2 -> getString(R.string.order_completed)
            3 -> getString(R.string.order_cancelled)
            else -> getString(R.string.order_confirmed)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}