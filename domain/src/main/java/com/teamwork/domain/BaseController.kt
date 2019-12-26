package com.teamwork.domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.teamwork.model.Empty
import com.teamwork.model.ErrorHandler
import com.teamwork.network.Result
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

open class BaseController {

    suspend fun <T : Any, Z : Any> apiCall(
        call: suspend () -> Response<T>,
        errorHandler: Class<Z>
    ): Any? {

        try {
            val result = apiResult(call, errorHandler)

            val data: Any?

            data = when (result) {
                is Result.Success ->
                    result.data
                is Result.Error -> {
                    result.exception
                }
            }

            return data
        } catch (e: HttpException) {
            return createNetworkError()
        } catch (e: IOException) {
            return createNetworkError()
        } catch (e: Throwable) {
            return createNetworkError()
        }

    }

    private fun createNetworkError(): ErrorHandler {
        return ErrorHandler()
    }


    @Suppress("BlockingMethodInNonBlockingContext")
    private suspend fun <T : Any, Z : Any> apiResult(
        call: suspend () -> Response<T>,
        errorHandler: Class<Z>
    ): Result<Any, Any> {
        val response = call.invoke()
        try {
            if (response.isSuccessful) {
                return if (response.body() == null) {
                    Result.Success(Empty())
                } else {
                    Result.Success(response.body()!!)
                }
            }

            return if (response.errorBody() != null) {
                val mapper = ObjectMapper()
                val mResponse = mapper.readValue(
                    response.errorBody()!!.string(),
                    errorHandler
                )

                return Result.Error(mResponse)
            } else {
                val error = response.errorBody()!!.string()
                Result.Error(error)
            }
        } catch (exception: Exception) {
            return Result.Error(Empty())
        }
    }
}
