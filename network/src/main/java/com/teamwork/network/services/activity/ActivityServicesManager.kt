package com.teamwork.network.services.activity

import com.teamwork.model.response.activity.LatestActivityResponse
import retrofit2.Response

class ActivityServicesManager(private val services: ActivityServices) {

    suspend fun getLatestActivity(): Response<LatestActivityResponse> {
        return services.getLatestActivity().await()
    }

}