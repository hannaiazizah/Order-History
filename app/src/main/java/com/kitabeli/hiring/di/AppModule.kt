package com.kitabeli.hiring.di

import com.kitabeli.hiring.data.datasource.OrdersRemoteDataSourceImpl
import com.kitabeli.hiring.data.remote.OrderService
import com.kitabeli.hiring.data.remote.OrdersRemoteDataSource
import com.kitabeli.hiring.data.repository.OrderRepository
import com.kitabeli.hiring.data.repository.OrderRepositoryImpl
import com.kitabeli.hiring.presentation.OrderHistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { OrderService.create() as OrderService }

    factory { OrdersRemoteDataSourceImpl(get()) as OrdersRemoteDataSource }

    factory { OrderRepositoryImpl(get()) as OrderRepository }

    viewModel { OrderHistoryViewModel(get()) }
}