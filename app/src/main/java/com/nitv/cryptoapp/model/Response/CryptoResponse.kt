package com.nitv.cryptoapp.model.Response
import com.google.gson.annotations.SerializedName
import com.nitv.cryptoapp.model.home.Data
import com.nitv.cryptoapp.model.home.Status

data class CryptoResponse(
    @SerializedName("data")
    val data : List<Data>?,
    @SerializedName("status")
    val status: Status?
)