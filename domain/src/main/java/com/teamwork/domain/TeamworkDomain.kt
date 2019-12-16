package com.teamwork.domain

import com.teamwork.model.Domain
import com.teamwork.model.Environment
import com.teamwork.network.TeamworkNetwork

class TeamworkDomain private constructor(private val domain: Domain) {

    private var network: TeamworkNetwork
    var domainControllers: DomainControllers

    companion object {

        private var domainSdk: TeamworkDomain? = null

        fun init(domain: Domain): TeamworkDomain {
            if (domainSdk == null) {
                domainSdk = TeamworkDomain(domain)
            }
            return domainSdk!!
        }
    }

    init {
        network = initNetwork()
        domainControllers = DomainControllers(network, this)
    }


    fun setAuthorizationBearer(auth: String) {
        network.setAuthorizationBearer(auth)
        domain.auth = auth
    }


    private fun initNetwork(): TeamworkNetwork {
        return TeamworkNetwork.init(Environment(domain.environment), domain.buildConfigDebug)
    }
}