package com.nitv.cryptoapp.model.detail


import com.nitv.cryptoapp.model.detail.CoinDetail
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("ETH")
    val eTH: List<CoinDetail>?
)