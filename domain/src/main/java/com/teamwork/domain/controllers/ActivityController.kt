package com.teamwork.domain.controllers

import com.teamwork.domain.BaseController
import com.teamwork.model.ErrorHandler
import com.teamwork.model.response.activity.LatestActivityResponse
import com.teamwork.network.TeamworkNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityController (private val network: TeamworkNetwork) : BaseController(network, null) {

    fun getLatestActivity(
        success: (data: LatestActivityResponse) -> Unit,
        error: (error: ErrorHandler) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            var response = apiCall(
                call = { network.getActivityServicesManager().getLatestActivity() },
                errorHandler = ErrorHandler::class.java
            )

            when (response) {
                is ErrorHandler -> error(response)
                is LatestActivityResponse -> success(response)
            }
        }
    }

}