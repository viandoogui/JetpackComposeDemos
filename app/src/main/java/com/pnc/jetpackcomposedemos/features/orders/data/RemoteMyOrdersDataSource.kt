package com.pnc.jetpackcomposedemos.features.orders.data

import com.pnc.jetpackcomposedemos.features.orders.MyOrderResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteMyOrdersDataSource: MyOrdersDataSource {

    @GET("my/customers/{customerId}/orders") // retrofit generates the code for this object
    override suspend fun getOrders(
        @Path("customerId") customerId: Int,  // normally implicit
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): MyOrderResponseDto
}