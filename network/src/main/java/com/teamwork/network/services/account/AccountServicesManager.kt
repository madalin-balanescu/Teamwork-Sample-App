package com.teamwork.network.services.account

import com.teamwork.model.response.account.AccountResponse
import retrofit2.Response

class AccountServicesManager (private val services: AccountServices) {

    suspend fun getAccount(): Response<AccountResponse> {
        return services.getAccountAsync().await()
    }

}