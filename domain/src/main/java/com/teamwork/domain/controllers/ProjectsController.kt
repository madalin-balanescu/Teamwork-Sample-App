package com.teamwork.domain.controllers

import com.teamwork.domain.BaseController
import com.teamwork.model.ErrorHandler
import com.teamwork.model.response.projects.AllProjectsResponse
import com.teamwork.network.TeamworkNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProjectsController(private val network: TeamworkNetwork) : BaseController(network, null) {


    fun getProjects(
        success: (data: AllProjectsResponse) -> Unit,
        error: (error: ErrorHandler) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            var response = apiCall(
                call = { network.getProjectsServicesManager().getProjects() },
                errorHandler = ErrorHandler::class.java
            )

            when (response) {
                is ErrorHandler -> error(response)
                is AllProjectsResponse -> success(response)
            }
        }
    }

    fun getSingleProject(
        id: Int,
        success: (data: Any) -> Unit,
        error: (error: ErrorHandler) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            var response = apiCall(
                call = { network.getProjectsServicesManager().getSingleProject(id) },
                errorHandler = ErrorHandler::class.java
            )

            when (response) {
                is ErrorHandler -> error(response)
                is Any -> success(response)
            }
        }
    }

}