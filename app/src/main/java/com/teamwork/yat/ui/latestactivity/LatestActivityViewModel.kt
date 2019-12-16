package com.teamwork.yat.ui.latestactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.teamwork.model.ErrorHandler
import com.teamwork.model.response.activity.LatestActivityResponse
import com.teamwork.yat.application.TeamworkApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LatestActivityViewModel(application: Application) : AndroidViewModel(application) {

    var latestActivityResult: MutableLiveData<LatestActivityResponse> = MutableLiveData()
    var errorResult: MutableLiveData<ErrorHandler> = MutableLiveData()

    fun getLatestActivity() {
        (getApplication() as TeamworkApp).getDomainController()
            .activityController.getLatestActivity({ data ->

            CoroutineScope(Dispatchers.Main).launch {
                latestActivityResult.value = data

            }
        }, { error ->
            CoroutineScope(Dispatchers.Main).launch {
                errorResult.value = error
            }
        })
    }

}