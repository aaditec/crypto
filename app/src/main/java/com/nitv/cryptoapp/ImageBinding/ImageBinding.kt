package com.nitv.cryptoapp.ImageBinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.nitv.cryptoapp.utils.loadImage

class ImageBinding {
    companion object {
        @BindingAdapter("load_image")
        @JvmStatic
        fun loadImage(imageView: ImageView, coinImage: String) {
            val imageUrl = "https://s2.coinmarketcap.com/static/img/coins/64x64/$coinImage.png"
            imageView.loadImage(imageUrl)
        }
    }
}