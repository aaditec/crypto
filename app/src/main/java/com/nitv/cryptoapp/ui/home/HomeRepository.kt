package com.nitv.cryptoapp.ui.home


import com.nitv.cryptoapp.network.ApiFactory
import com.nitv.cryptoapp.repository.Repository
import javax.inject.Inject


class HomeRepository @Inject constructor(private val apiFactory: ApiFactory) : Repository() {
    suspend fun getData(
        apiKey: String
    ) = apiRequest {
        apiFactory.getData(apiKey)
    }
}