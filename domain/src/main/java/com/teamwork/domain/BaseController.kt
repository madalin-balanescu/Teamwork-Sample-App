package com.teamwork.domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.teamwork.model.Empty
import com.teamwork.model.ErrorHandler
import com.teamwork.network.Result
import com.teamwork.network.TeamworkNetwork
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

open class BaseController(private val network: TeamworkNetwork, private val domain: TeamworkDomain?) {

    suspend fun <T : Any, Z : Any> apiCall(
        call: suspend () -> Response<T>,
        errorHandler: Class<Z>
    ): Any? {

        try {
            val result = apiResult(call, errorHandler)

            var data: Any? = null

            when (result) {
                is Result.Success ->
                    data = result.data
                is Result.Error -> {
                    data = result.exception
                }
            }

            return data
        } catch (e: HttpException) {
            return createNetworkError(e.message.toString())
        } catch (e: IOException) {
            return createNetworkError(e.message.toString())
        } catch (e: Throwable) {
            return createNetworkError(e.message.toString())
        }

    }

    private fun createNetworkError(errorName: String): ErrorHandler {
        return ErrorHandler()
    }


    private suspend fun <T : Any, Z : Any> apiResult(
        call: suspend () -> Response<T>,
        errorHandler: Class<Z>
    ): Result<T, Z> {
        val response = call.invoke()
        try {
            if (response.isSuccessful) {
                return if (response.body() == null) {
                    Result.Success(Empty() as T)
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
                var error = response.errorBody()!!.string()
                Result.Error(error as Z)
            }
        } catch (exception: Exception) {
            return Result.Error(Empty() as Z)
        }
    }
}
