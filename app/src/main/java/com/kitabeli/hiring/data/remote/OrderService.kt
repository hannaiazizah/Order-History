package com.kitabeli.hiring.data.remote

import com.kitabeli.hiring.domain.OrderResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface OrderService {
    @GET("api/v1/logistics/order")
    suspend fun getOrderHistory(
        @Query("page") page: Int,
        @Query("size") limit: Int,
        @Query("userId") userId: Int = 104913,
        @Query("status") status: String
    ): Response<OrderResponse>

    companion object {
        private const val BASE_URL = "https://logistics-dev.kitabeli.id/"

        fun create(): OrderService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.HEADERS

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OrderService::class.java)
        }
    }
}