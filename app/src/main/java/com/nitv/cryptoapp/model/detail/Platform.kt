package com.nitv.cryptoapp.model.detail


import com.nitv.cryptoapp.model.detail.Coin
import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("coin")
    val coin: Coin?,
    @SerializedName("name")
    val name: String?
)