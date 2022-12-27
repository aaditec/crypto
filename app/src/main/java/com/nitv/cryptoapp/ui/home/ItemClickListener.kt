package com.nitv.cryptoapp.ui.home

import com.nitv.cryptoapp.model.home.Data


interface ItemClickListener {
    fun onItemClick(coin: Data)
}