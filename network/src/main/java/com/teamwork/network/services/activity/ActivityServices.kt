package com.teamwork.network.services.activity

import com.teamwork.model.response.activity.LatestActivityResponse
import com.teamwork.network.API_GET_LATEST_ACTIVITY
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ActivityServices {

    @GET(API_GET_LATEST_ACTIVITY)
    fun getLatestActivityAsync(): Deferred<Response<LatestActivityResponse>>

}
