package com.pnc.jetpackcomposedemos.testutil.fakes

import com.pnc.jetpackcomposedemos.features.artists.data.ArtistDataSource
import com.pnc.jetpackcomposedemos.features.artists.data.ArtistDto
import com.pnc.jetpackcomposedemos.features.orders.MyOrderResponseDto
import com.pnc.jetpackcomposedemos.features.orders.data.MyOrdersDataSource
import com.pnc.jetpackcomposedemos.features.orders.data.OrderDataSource
import com.pnc.jetpackcomposedemos.features.orders.data.OrderLineItemDto
import com.pnc.jetpackcomposedemos.testutil.builders.anArtistDto
import javax.inject.Inject
import javax.inject.Singleton

// @Singleton + @Inject constructor (in testing) means that Hilt creates ONE instance per test
@Singleton
class FakeArtistDataSource @Inject constructor(

): ArtistDataSource {
    var artists: List<ArtistDto> = listOf(
        anArtistDto(id = 1, name = "Abe"),
        anArtistDto(id = 2, name = "Bea"),
    )

    val failure: Throwable? = null
    override suspend fun getArtists(): List<ArtistDto> {
        failure?.let { throw it }
        return artists
    }

    override suspend fun getArtist(id: Int): ArtistDto {
        failure?.let { throw it }
        return artists.first { it.id == id }
    }

}

@Singleton
class FakeOrderDataSource @Inject constructor(): OrderDataSource {
    var lineItems: List<OrderLineItemDto> = emptyList()
    var failure: Throwable? = null // any test can reach in and set this to have a certain failure (also can set response to be custom)

    override suspend fun getOrders(): List<OrderLineItemDto> {
        failure?.let { throw it }
        return lineItems
    }

}

@Singleton
class FakeMyOrdersDataSource @Inject constructor(): MyOrdersDataSource {
    var response = MyOrderResponseDto(
        customerId = 1,
        page = 1,
        pageSize = 100,
        totalOrders = 0,
        orders = emptyList()
    )
    var failure: Throwable? = null
    var lastCustomerId: Int? = null

    override suspend fun getOrders(
        customerId: Int,
        page: Int,
        pageSize: Int): MyOrderResponseDto {

        lastCustomerId = customerId
        failure?.let { throw it }
        return response
    }

}