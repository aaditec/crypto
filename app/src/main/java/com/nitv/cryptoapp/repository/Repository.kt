package com.nitv.cryptoapp.repository

import com.nitv.cryptoapp.R
import com.nitv.cryptoapp.model.Response.ErrorResponse
import com.nitv.cryptoapp.utils.NetworkResult
import com.google.gson.Gson
import com.nitv.cryptoapp.MyApplication.Companion.getAppContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class Repository {
    suspend fun <T> apiRequest(
        apiRequest: suspend () -> T
    ): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                NetworkResult.Success(apiRequest.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        NetworkResult.Error(
                            false,
                            errorBodyParser(throwable.response()?.errorBody()?.string())
                        )
                    }
                    else -> NetworkResult.Error(true, throwable.localizedMessage)
                }
            }
        }
    }
}

private fun errorBodyParser(error: String?): String {
    error?.let {
        return try {
            val errorResponse = Gson().fromJson(error, ErrorResponse::class.java)
            val errorMessage = errorResponse.status?.errorMessage
            errorMessage ?: getAppContext().resources.getString(R.string.error_message)
        } catch (e: Exception) {
            getAppContext().resources.getString(R.string.error_message)
        }
    }
    return getAppContext().resources.getString(R.string.error_message)
}