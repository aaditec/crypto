package com.nitv.cryptoapp.ui.home

import com.nitv.cryptoapp.base.BaseRepository
import com.nitv.cryptoapp.network.ApiFactory
import javax.inject.Inject


class HomeRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {

    suspend fun getData(
        apiKey: String
    ) = safeApiRequest {
        apiFactory.getData(apiKey)
    }
}