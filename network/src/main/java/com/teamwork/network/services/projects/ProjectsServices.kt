package com.teamwork.network.services.projects

import com.teamwork.model.response.projects.AllProjectsResponse
import com.teamwork.network.API_GET_PROJECTS
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ProjectsServices{

    @GET(API_GET_PROJECTS)
    fun getProjectsAsync(): Deferred<Response<AllProjectsResponse>>

}