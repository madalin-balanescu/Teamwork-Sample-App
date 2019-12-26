package com.teamwork.yat.ui.projects

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
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.teamwork.model.response.projects.AllProjectsResponse
import com.teamwork.model.ui.projects.ProjectListItem
import com.teamwork.yat.R
import com.teamwork.yat.databinding.FragmentProjectsBinding
import com.teamwork.yat.ui.projects.adapter.ItemRowClickListener
import com.teamwork.yat.ui.projects.adapter.ProjectAdapter
import com.teamwork.yat.ui.utils.AlertDialogUtils
import com.teamwork.yat.ui.utils.NetworkValidationUtils
import kotlinx.android.synthetic.main.fragment_projects.*

class ProjectsFragment : Fragment(), ItemRowClickListener {

    private lateinit var projectsViewModel: ProjectsViewModel
    private lateinit var binding: FragmentProjectsBinding

    private var layoutManager: LinearLayoutManager? = null
    private var projectAdapter: ProjectAdapter<Any>? = null

    private var projectItemList = mutableListOf<Any>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        projectsViewModel =
            ViewModelProviders.of(this).get(ProjectsViewModel::class.java)

        manageViewModels()

        binding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_projects,
                container,
                false
            )
        binding.fragmentProjects = this
        return binding.root
    }

    private fun manageViewModels() {
        projectsViewModel.projectResult.observe(this, Observer {
            progressBar.visibility = View.GONE
            createProjectsUIList(it)
        })

        projectsViewModel.errorResult.observe(this, Observer {
            progressBar.visibility = View.GONE
            it.error?.let { error ->
                context?.let { context -> AlertDialogUtils.showAlert(context, error) }
            }
        })
    }

    private fun createProjectsUIList(allProjectsResponse: AllProjectsResponse) {
        allProjectsResponse.projects?.let { projects ->
            if (projectItemList.isEmpty()) {
                for (item in projects) {
                    if (item != null) {

                        val projectItem = ProjectListItem()

                        if (item.company != null && !item.company!!.name.isNullOrEmpty()) {
                            projectItem.companyName = item.company!!.name
                            projectItemList.add(item.company!!.name!!)
                        }

                        if (!item.description.isNullOrEmpty()) {
                            projectItem.description = item.description
                        }

                        if (!item.name.isNullOrEmpty()) {
                            projectItem.name = item.name
                        }

                        if (!item.tags.isNullOrEmpty()) {
                            projectItem.tags = item.tags
                        }

                        projectItemList.add(projectItem)
                    }
                }
            }

            initData()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        getProjects()
    }

    private fun getProjects() {
        if (!NetworkValidationUtils.isNetworkAvailable(context)) {
            progressBar.visibility = View.VISIBLE
            projectsViewModel.getProjects()
        } else {
            Toast.makeText(
                context,
                resources.getString(R.string.no_internet_connection),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun initData() {
        projectAdapter = ProjectAdapter(projectItemList, this)
        rvProjects.adapter = projectAdapter
    }

    private fun initAdapter() {
        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvProjects.setHasFixedSize(true)
        rvProjects.layoutManager = layoutManager
        rvProjects.itemAnimator = DefaultItemAnimator()
    }

    override fun projectItemSelected(name: String) {
         MaterialAlertDialogBuilder(context)
            .setTitle(name)
            .setMessage(getString(R.string.not_developed_yet))
            .setPositiveButton("Ok", null)
            .show()
    }
}