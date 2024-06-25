package com.dara.core.network.utils

import com.dara.core.network.R
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

/**
 * Handles network errors and returns appropriate error message.
 */

interface ErrorHandler {

    fun getErrorMessage(e: Throwable): String
}

class ErrorHandlerImpl @Inject constructor(
    private val stringProvider: StringProvider
) : ErrorHandler {
    override fun getErrorMessage(e: Throwable): String {
        return when (e) {
            is UnknownHostException -> stringProvider.getString(R.string.no_internet_connection)
            is SocketTimeoutException -> stringProvider.getString(R.string.request_timed_out)
            is HttpException -> stringProvider.getString(R.string.server_error)
            else -> stringProvider.getString(R.string.something_went_wrong)
        }
    }
}
