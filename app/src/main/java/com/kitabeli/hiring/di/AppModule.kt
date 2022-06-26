package com.kitabeli.hiring.di

import com.kitabeli.hiring.data.datasource.OrdersRemoteDataSourceImpl
import com.kitabeli.hiring.data.remote.OrderService
import com.kitabeli.hiring.data.repository.OrderRepositoryImpl
import com.kitabeli.hiring.presentation.OrderHistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { OrderService.create() }

    factory { OrdersRemoteDataSourceImpl(get()) }

    factory { OrderRepositoryImpl(get()) }

    viewModel { OrderHistoryViewModel(get()) }
}