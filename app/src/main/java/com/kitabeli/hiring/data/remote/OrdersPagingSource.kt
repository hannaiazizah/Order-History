package com.kitabeli.hiring.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kitabeli.hiring.domain.OrderHistory
import java.io.IOException
import retrofit2.HttpException

class OrdersPagingSource(
    private val status: String,
    private val service: OrderService
) : PagingSource<Int, OrderHistory>() {

    override fun getRefreshKey(state: PagingState<Int, OrderHistory>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, OrderHistory> {
        val pageIndex = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = service.getOrderHistory(
                limit = PAGE_LIMIT,
                page = pageIndex,
                status = status
            )
            val orders = response.body()?.data?.orders ?: emptyList()
            val nextKey =
                if (orders.isNullOrEmpty()) {
                    null
                } else {
                    // By default, initial load size = 3 * NETWORK PAGE SIZE
                    // ensure we're not requesting duplicating items at the 2nd request
                    pageIndex + (params.loadSize / PAGE_LIMIT)
                }
            LoadResult.Page(
                data = orders,
                prevKey = if (pageIndex == STARTING_PAGE_INDEX) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 0
        const val PAGE_LIMIT = 20
    }
}