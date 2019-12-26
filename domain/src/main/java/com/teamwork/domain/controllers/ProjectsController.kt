package com.teamwork.domain.controllers

import com.teamwork.domain.BaseController
import com.teamwork.model.ErrorHandler
import com.teamwork.model.response.projects.AllProjectsResponse
import com.teamwork.network.TeamworkNetwork
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProjectsController(private val network: TeamworkNetwork) : BaseController() {


    fun getProjects(
        success: (data: AllProjectsResponse) -> Unit,
        error: (error: ErrorHandler) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiCall(
                call = { network.getProjectsServicesManager().getProjects() },
                errorHandler = ErrorHandler::class.java
            )

            when (response) {
                is ErrorHandler -> error(response)
                is AllProjectsResponse -> success(response)
            }
        }
    }

}