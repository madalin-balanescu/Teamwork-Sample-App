package com.teamwork.network.services.projects

import com.teamwork.model.response.projects.AllProjectsResponse
import retrofit2.Response

class ProjectsServicesManager (private val services: ProjectsServices) {

    suspend fun getProjects(): Response<AllProjectsResponse> {
        return services.getProjects().await()
    }

    suspend fun getSingleProject(id: Int): Response<Any> {
        return services.getSingleProject(id).await()
    }


}