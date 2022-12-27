package com.nitv.cryptoapp.ui.detail

import com.nitv.cryptoapp.base.BaseRepository
import com.nitv.cryptoapp.network.ApiFactory
import javax.inject.Inject


class DetailRepository @Inject constructor(private val apiFactory: ApiFactory) : BaseRepository() {
    suspend fun getDetail(
        apiKey: String,
        symbol: String
    ) = safeApiRequest {
        apiFactory.getDetail(apiKey, symbol)
    }
}