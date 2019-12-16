package com.teamwork.network.services.account

import com.teamwork.model.response.account.AccountResponse
import com.teamwork.network.API_GET_ACCOUNT
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface AccountServices {

    @GET(API_GET_ACCOUNT)
    fun getAccount(): Deferred<Response<AccountResponse>>

}