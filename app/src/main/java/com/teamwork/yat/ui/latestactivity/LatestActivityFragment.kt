package com.teamwork.yat.ui.latestactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teamwork.model.response.activity.LatestActivityResponse
import com.teamwork.model.ui.activity.LatestActivityListItem
import com.teamwork.yat.R
import com.teamwork.yat.databinding.FragmentLatestactivityBinding
import com.teamwork.yat.ui.latestactivity.adapter.LatestActivityAdapter
import com.teamwork.yat.ui.utils.AlertDialogUtils
import com.teamwork.yat.ui.utils.NetworkValidationUtils
import kotlinx.android.synthetic.main.fragment_latestactivity.*
import java.text.SimpleDateFormat
import java.util.*


class LatestActivityFragment : Fragment() {

    private lateinit var latestActivityViewModel: LatestActivityViewModel
    private lateinit var binding: FragmentLatestactivityBinding

    private var layoutManager: LinearLayoutManager? = null
    private var latestActivityAdapter: LatestActivityAdapter<Any>? = null

    private var activityList = mutableListOf<Any>()

    var sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        latestActivityViewModel =
            ViewModelProviders.of(this).get(LatestActivityViewModel::class.java)
        manageViewModels()

        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_latestactivity,
                container,
                false
            )
        binding.fragmentLatestActivity = this
        return binding.root
    }

    private fun manageViewModels() {
        latestActivityViewModel.latestActivityResult.observe(this, Observer {
            progressBar.visibility = View.GONE
            createLatestActivityUIList(it)
        })

        latestActivityViewModel.errorResult.observe(this, Observer {
            progressBar.visibility = View.GONE
            it.error?.let { error ->
                context?.let { context -> AlertDialogUtils.showAlert(context, error) }
            }

        })
    }

    private fun createLatestActivityUIList(latestActivitylist: LatestActivityResponse) {
        latestActivitylist.activity?.let { activity ->
            if (activityList.isEmpty()) {
                var latestHeader = ""
                for (item in activity) {
                    if (item != null) {

                        var latestActivityListItem = LatestActivityListItem()

                        if (!item.projectName.isNullOrEmpty()) {
                            latestActivityListItem.projectName = item.projectName

                            if (latestHeader.isNullOrEmpty()) {
                                latestHeader = item.projectName!!
                                activityList.add(latestHeader)
                            } else if (item.projectName != latestHeader) {
                                latestHeader = item.projectName!!
                                activityList.add(latestHeader)
                            }
                        }

                        if (!item.companyName.isNullOrEmpty()) {
                            latestActivityListItem.companyName = item.companyName
                        }

                        if (!item.activitytype.isNullOrEmpty()) {
                            latestActivityListItem.activityType = item.activitytype
                        }

                        if (!item.description.isNullOrEmpty()) {
                            latestActivityListItem.description = item.description
                        }

                        if (!item.forUserAvatarUrl.isNullOrEmpty()) {
                            latestActivityListItem.userAvatar = item.forUserAvatarUrl
                        }

                        if (!item.datetime.isNullOrEmpty()) {
                            try {
                                var date = sdf.parse(item.datetime!!)
                                latestActivityListItem.dateTime = date.time
                            } catch (e: Exception) {
                                latestActivityListItem.dateTime = null
                            }
                        }

                        activityList.add(latestActivityListItem)
                    }
                }
            }
            initData()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        getLatestActivity()
    }

    private fun getLatestActivity() {
        if (NetworkValidationUtils.isNetworkAvailable(context)) {
            progressBar.visibility = View.VISIBLE
            latestActivityViewModel.getLatestActivity()
        } else {
            Toast.makeText(
                context,
                resources.getString(R.string.no_internet_connection),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun initData() {
        latestActivityAdapter = LatestActivityAdapter(activityList)
        rvActivities.adapter = latestActivityAdapter
    }

    private fun initAdapter() {
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvActivities.setHasFixedSize(true)
        rvActivities.layoutManager = layoutManager
        rvActivities.itemAnimator = DefaultItemAnimator()
    }
}