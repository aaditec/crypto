package com.nitv.cryptoapp.model.Response


import com.google.gson.annotations.SerializedName
import com.nitv.cryptoapp.model.detail.Status

data class DetailResponse(
    @SerializedName("data")
    val data: Any?,
    @SerializedName("status")
    val status: Status?
)