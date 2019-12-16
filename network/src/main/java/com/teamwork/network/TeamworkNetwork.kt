package com.teamwork.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.teamwork.model.Environment
import com.teamwork.network.services.account.AccountServices
import com.teamwork.network.services.account.AccountServicesManager
import com.teamwork.network.services.activity.ActivityServices
import com.teamwork.network.services.activity.ActivityServicesManager
import com.teamwork.network.services.projects.ProjectsServices
import com.teamwork.network.services.projects.ProjectsServicesManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

class TeamworkNetwork private constructor(
    private val environment: Environment,
    private val buildConfigDebug: Boolean
) {

    private var accountServices: AccountServices
    private var activityServices: ActivityServices
    private var projectsServices: ProjectsServices

    var token: String = ""

    companion object {

        private var networkSdk: TeamworkNetwork? = null

        fun init(environment: Environment, buildConfigDebug: Boolean): TeamworkNetwork {
            if (networkSdk == null) {
                networkSdk = TeamworkNetwork(environment, buildConfigDebug)
            }
            return networkSdk!!
        }
    }

    init {
        accountServices = initAccountService()
        activityServices = initActivityService()
        projectsServices = initProjectsService()
    }

    fun setAuthorizationBearer(accessToken: String) {
        token = accessToken
    }

    private fun initProjectsService(): ProjectsServices {
        return initAdapter().create(ProjectsServices::class.java)
    }

    private fun initAccountService(): AccountServices {
        return initAdapter().create(AccountServices::class.java)
    }

    private fun initActivityService(): ActivityServices {
        return initAdapter().create(ActivityServices::class.java)
    }

    fun getAccountServicesManager(): AccountServicesManager {
        return AccountServicesManager(accountServices)
    }

    fun getActivityServicesManager(): ActivityServicesManager {
        return ActivityServicesManager(activityServices)
    }

    fun getProjectsServicesManager(): ProjectsServicesManager {
        return ProjectsServicesManager(projectsServices)
    }


    private fun initBuilder(): OkHttpClient.Builder{
        val builder = OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
        val interceptorHttpLogging: HttpLoggingInterceptor

        if (buildConfigDebug) {
            interceptorHttpLogging = HttpLoggingInterceptor()
            interceptorHttpLogging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptorHttpLogging)
        }

        val interceptorHeader = Interceptor { chain ->
            val request =
                if (!token.isEmpty()) {
                    chain.request().newBuilder()
                        .addHeader(HEADER_ACCEPT, JSON)
                        .addHeader(HEADER_CONTENT_TYPE, JSON)
                        .addHeader(AUTHORIZATION, getAccessToken())
                        .build()
                } else {
                    chain.request().newBuilder()
                        .build()
                }


            chain.proceed(request)
        }

        builder.networkInterceptors().add(interceptorHeader)

        return builder
    }

    private fun initAdapter(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(environment.baseUrl)
            .addConverterFactory(JacksonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(initBuilder().build())
            .build()
    }

    private fun getAccessToken(): String{
        return token
    }

}