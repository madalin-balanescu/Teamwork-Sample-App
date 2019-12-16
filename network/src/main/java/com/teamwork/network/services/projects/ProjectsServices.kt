package com.teamwork.network.services.projects

import com.teamwork.model.response.projects.AllProjectsResponse
import com.teamwork.network.API_GET_PROJECTS
import com.teamwork.network.API_GET_SINGLE_PROJECT
import com.teamwork.network.ID
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProjectsServices{

    @GET(API_GET_PROJECTS)
    fun getProjects(): Deferred<Response<AllProjectsResponse>>

    @GET(API_GET_SINGLE_PROJECT)
    fun getSingleProject(@Query(ID) id: Int): Deferred<Response<Any>>

}