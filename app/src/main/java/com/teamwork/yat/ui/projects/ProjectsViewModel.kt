package com.teamwork.yat.ui.projects

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.teamwork.model.ErrorHandler
import com.teamwork.model.response.projects.AllProjectsResponse
import com.teamwork.yat.application.TeamworkApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProjectsViewModel(application: Application) : AndroidViewModel(application) {

    var projectResult: MutableLiveData<AllProjectsResponse> = MutableLiveData()
    var errorResult: MutableLiveData<ErrorHandler> = MutableLiveData()

    fun getProjects() {
        (getApplication() as TeamworkApp).getDomainController()
            .projectsController.getProjects({ data ->

            CoroutineScope(Dispatchers.Main).launch {
                projectResult.value = data

            }
        }, { error ->
            CoroutineScope(Dispatchers.Main).launch {
                errorResult.value = error
            }
        })
    }
}