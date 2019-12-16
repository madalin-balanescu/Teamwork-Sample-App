package com.teamwork.yat.application

import android.app.Application
import com.appizona.yehiahd.fastsave.FastSave
import com.teamwork.domain.DomainControllers
import com.teamwork.domain.DomainSharedPreferences
import com.teamwork.domain.TeamworkDomain
import com.teamwork.model.Domain
import com.teamwork.yat.BuildConfig
import okhttp3.Credentials

class TeamworkApp : Application(), DomainSharedPreferences {

    private lateinit var domain: TeamworkDomain

    fun getDomainController(): DomainControllers {
        return domain.domainControllers
    }

    override fun onCreate() {
        super.onCreate()
        FastSave.init(applicationContext)
        domain = initDomain()
        saveAuth(createCredentials())
        setAuth()
    }

    private fun createCredentials(): String{
        return Credentials.basic(BuildConfig.API_TOKEN, BuildConfig.API_PASSWORD)
    }

    private fun initDomain(): TeamworkDomain {
        return TeamworkDomain.init(createDomainEntity())
    }

    private fun createDomainEntity(): Domain {
        var domainEntity = Domain()
        domainEntity.environment = BuildConfig.BASE_URL
        domainEntity.buildConfigDebug = BuildConfig.DEBUG
        return domainEntity
    }

    override fun saveAuth(token: String) {
        FastSave.getInstance().saveString(DomainSharedPreferences.AUTHORIZATION_BEARER, token)
        domain.setAuthorizationBearer(token)
    }

    override fun getAuth(): String? {
        return FastSave.getInstance()
            .getString(DomainSharedPreferences.AUTHORIZATION_BEARER, "")
    }

    override fun setAuth() {
        getAuth()?.let { domain.setAuthorizationBearer(it) }
    }

}