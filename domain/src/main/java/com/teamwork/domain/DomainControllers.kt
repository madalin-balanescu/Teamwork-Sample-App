package com.teamwork.domain

import com.teamwork.domain.controllers.AccountController
import com.teamwork.domain.controllers.ActivityController
import com.teamwork.domain.controllers.ProjectsController
import com.teamwork.network.TeamworkNetwork

class DomainControllers(
    private val network: TeamworkNetwork,
    private val domain: TeamworkDomain
) {

    lateinit var accountController: AccountController
    lateinit var activityController: ActivityController
    lateinit var projectsController: ProjectsController

    init {
        initControllers()
    }

    private fun initControllers() {
        accountController = AccountController(network)
        activityController = ActivityController(network)
        projectsController = ProjectsController(network)
    }

}