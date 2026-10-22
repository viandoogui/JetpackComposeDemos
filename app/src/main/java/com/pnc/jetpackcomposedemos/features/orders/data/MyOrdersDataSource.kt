package com.pnc.jetpackcomposedemos.features.orders.data

import com.pnc.jetpackcomposedemos.features.orders.MyOrderResponseDto

interface MyOrdersDataSource {
    suspend fun getOrders(customerId: Int, page: Int, pageSize: Int): MyOrderResponseDto
}