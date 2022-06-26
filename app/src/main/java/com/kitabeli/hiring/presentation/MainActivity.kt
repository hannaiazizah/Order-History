package com.kitabeli.hiring.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.kitabeli.hiring.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        val viewPager = findViewById<ViewPager2>(R.id.pager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        val pagerAdapter = OrderCollectionPagerAdapter(this)
        viewPager.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
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
}