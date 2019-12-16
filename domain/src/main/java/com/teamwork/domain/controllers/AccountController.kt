package com.teamwork.domain.controllers

import com.teamwork.domain.BaseController
import com.teamwork.model.ErrorHandler
import com.teamwork.model.response.account.AccountResponse
import com.teamwork.network.TeamworkNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccountController(private val network: TeamworkNetwork) : BaseController(network, null) {

    fun getAccount(
        success: (data: AccountResponse) -> Unit,
        error: (error: ErrorHandler) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            var response = apiCall(
                call = { network.getAccountServicesManager().getAccount() },
                errorHandler = ErrorHandler::class.java
            )

            when (response) {
                is ErrorHandler -> error(response)
                is AccountResponse -> success(response)
            }
        }
    }

}