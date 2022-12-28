package com.nitv.cryptoapp.ui.detail

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.nitv.cryptoapp.base.BaseFragment
import com.nitv.cryptoapp.model.detail.CoinDetail
import com.nitv.cryptoapp.model.Response.DetailResponse

import com.nitv.cryptoapp.utils.Constants.API_KEY
import com.nitv.cryptoapp.utils.loadImage
import com.nitv.cryptoapp.databinding.FragmentDetailBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONArray
import org.json.JSONObject

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(
    FragmentDetailBinding::inflate
) {
    override val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateFinished() {
        viewModel.getDetail(API_KEY, args.symbol)
    }

    override fun observeEvents() {
        with(viewModel) {
            detailResponse.observe(viewLifecycleOwner) {
                val gson = Gson()
                val json = gson.toJson(it?.data)
                val jsonObject = JSONObject(json)
                val jsonArray = jsonObject[args.symbol] as JSONArray
                val coin = gson.fromJson(jsonArray.getJSONObject(0).toString(), CoinDetail::class.java)
                coin?.let { it ->
                    with(binding) {
                        ivDetail.loadImage(it.logo)
                        tvDetailTitle.text = it.name
                        tvDetailSymbol.text = it.symbol
                        tvDetailDescription.text = it.description
                    }

                }
            }
            isLoading.observe(viewLifecycleOwner) {
                handleView(it)
            }
            onError.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun handleView(isLoading: Boolean = false) {
        binding.detailGroup.isVisible = !isLoading
        binding.pbDetail.isVisible = isLoading
    }
}