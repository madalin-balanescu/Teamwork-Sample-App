package com.teamwork.network.services.projects

import com.teamwork.model.response.projects.AllProjectsResponse
import retrofit2.Response

class ProjectsServicesManager (private val services: ProjectsServices) {

    suspend fun getProjects(): Response<AllProjectsResponse> {
        return services.getProjectsAsync().await()
    }


}