package com.teamwork.yat.ui.account

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.preference.PreferenceManager
import com.teamwork.model.response.account.Account
import com.teamwork.yat.R
import com.teamwork.yat.databinding.FragmentMyaccountBinding
import com.teamwork.yat.ui.utils.AlertDialogUtils
import com.teamwork.yat.ui.utils.NetworkValidationUtils
import kotlinx.android.synthetic.main.fragment_latestactivity.*


class MyAccountFragment : Fragment() {

    private lateinit var myaccountViewModel: MyAccountViewModel
    private lateinit var binding: FragmentMyaccountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myaccountViewModel =
            ViewModelProviders.of(this).get(MyAccountViewModel::class.java)
        manageViewModels()

        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_myaccount,
                container,
                false
            )
        binding.fragmentMyAccount = this
        return binding.root
    }

    private fun manageViewModels() {
        myaccountViewModel.accountResult.observe(this, Observer {
            progressBar.visibility = View.GONE
            it?.let {
                it.account?.let { account ->
                    editSettingsPreferences(account)
                }
            }
        })

        myaccountViewModel.errorResult.observe(this, Observer {
            progressBar.visibility = View.GONE
            it.error?.let { error ->
                context?.let { context -> AlertDialogUtils.showAlert(context, error) }
            }
        })
    }

    private fun editSettingsPreferences(account: Account) {
        val settings: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val sharedPreferenceEditor = settings.edit()

        account.userIsAdmin?.let {
            sharedPreferenceEditor.putBoolean("administrator", it)
        }

        account.projectsEnabled?.let {
            sharedPreferenceEditor.putBoolean("projects", it)
        }

        account.emailNotificationEnabled?.let {
            sharedPreferenceEditor.putBoolean("email_notification", it)
        }

        account.canPreviewFiles?.let {
            sharedPreferenceEditor.putBoolean("preview_files", it)
        }

        sharedPreferenceEditor.apply()

        childFragmentManager
            .beginTransaction()
            .replace(R.id.flSetting, SettingFragment())
            .commit()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getAccount()


    }

    private fun getAccount() {
        if (NetworkValidationUtils.isNetworkAvailable(context)) {
            progressBar.visibility = View.VISIBLE
            myaccountViewModel.getAccount()
        } else {
            Toast.makeText(
                context,
                resources.getString(R.string.no_internet_connection),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}