package com.teamwork.yat.ui.account

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.teamwork.model.ErrorHandler
import com.teamwork.model.response.account.AccountResponse
import com.teamwork.yat.application.TeamworkApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyAccountViewModel(application: Application) : AndroidViewModel(application) {

    var accountResult: MutableLiveData<AccountResponse> = MutableLiveData()
    var errorResult: MutableLiveData<ErrorHandler> = MutableLiveData()

    fun getAccount() {
        (getApplication() as TeamworkApp).getDomainController()
            .accountController.getAccount({ data ->

            CoroutineScope(Dispatchers.Main).launch {
                accountResult.value = data

            }
        }, { error ->
            CoroutineScope(Dispatchers.Main).launch {
                errorResult.value = error
            }
        })
    }

}