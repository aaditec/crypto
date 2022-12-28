package com.nitv.cryptoapp.ui.detail


import com.nitv.cryptoapp.network.ApiFactory
import com.nitv.cryptoapp.repository.Repository
import javax.inject.Inject


class DetailRepository @Inject constructor(private val apiFactory: ApiFactory) : Repository() {
    suspend fun getDetail(
        apiKey: String,
        symbol: String
    ) = apiRequest {
        apiFactory.getDetail(apiKey, symbol)
    }
}