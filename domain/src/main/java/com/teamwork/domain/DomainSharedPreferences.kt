package com.teamwork.domain

interface DomainSharedPreferences {

    companion object {
        const val AUTHORIZATION_BEARER = "AUTHORIZATION_BEARER"
    }

    fun saveAuth(token: String)

    fun getAuth(): String?

    fun setAuth()
}
