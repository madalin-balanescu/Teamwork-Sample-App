package com.teamwork.yat.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.teamwork.yat.R
import com.teamwork.yat.ui.utils.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var currentNavController: LiveData<NavController>? = null
    private val animationBarDuration: Long = 0
    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        initToolbarAndTitle(savedInstanceState)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    private fun initToolbarAndTitle(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

        bottomNav.itemIconTintList = null
    }

    private fun setupBottomNavigationBar() {
        bottomNavigationView = findViewById(R.id.bottomNav)

        val navGraphIds = listOf(
            R.navigation.nav_projects,
            R.navigation.nav_latestactivity,
            R.navigation.nav_account
        )

        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        controller.observe(this, Observer { navController ->
            setupActionBarWithNavController(this, navController)

            navController.addOnDestinationChangedListener { controller, destination, arguments ->
                when (destination.id) {
                    R.id.navigation_projects -> showBottomBar()
                    R.id.navigation_latestactivity -> showBottomBar()
                    R.id.navigation_account -> showBottomBar()
                    else -> hideBottomBar()
                }
            }
        })
        currentNavController = controller
    }

    private fun showBottomBar() {
        with(bottomNav) {
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .duration = animationBarDuration
        }
    }

    private fun hideBottomBar() {
        with(bottomNav) {
            if (visibility == View.VISIBLE && alpha == 1f) {
                animate()
                    .alpha(0f)
                    .withEndAction { visibility = View.GONE }
                    .duration = animationBarDuration
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    override fun onBackPressed() {
        if (currentNavController?.value?.popBackStack() != true) {
            super.onBackPressed()
        }
    }
}
