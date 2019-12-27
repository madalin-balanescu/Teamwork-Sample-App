package com.teamwork.yat

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.teamwork.model.response.account.AccountResponse
import com.teamwork.model.response.activity.LatestActivityResponse
import com.teamwork.model.response.projects.AllProjectsResponse
import com.teamwork.yat.application.TeamworkApp
import com.teamwork.yat.ui.account.MyAccountViewModel
import com.teamwork.yat.ui.latestactivity.LatestActivityViewModel
import com.teamwork.yat.ui.projects.ProjectsViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testAccountStatus() {
        val applicationMock = Mockito.mock(TeamworkApp::class.java)
        val myAccountViewModel = MyAccountViewModel(applicationMock)

        val accountResponse = Mockito.mock(AccountResponse::class.java)
        Mockito.`when`(accountResponse.sTATUS).thenReturn("OK")

        myAccountViewModel.accountResult.value = accountResponse

        myAccountViewModel.accountResult.value?.let {
            assertEquals(it.sTATUS, "OK")
        }
    }

    @Test
    fun testLatestActivityStatus() {
        val applicationMock = Mockito.mock(TeamworkApp::class.java)
        val latestActivityViewModel = LatestActivityViewModel(applicationMock)

        val latestActivityResponse = Mockito.mock(LatestActivityResponse::class.java)
        Mockito.`when`(latestActivityResponse.sTATUS).thenReturn("OK")

        latestActivityViewModel.latestActivityResult.value = latestActivityResponse

        latestActivityViewModel.latestActivityResult.value?.let {
            assertEquals(it.sTATUS, "OK")
        }
    }

    @Test
    fun testProjectStatus() {
        val applicationMock = Mockito.mock(TeamworkApp::class.java)
        val projectViewModel = ProjectsViewModel(applicationMock)

        val allProjectsResponse = Mockito.mock(AllProjectsResponse::class.java)
        Mockito.`when`(allProjectsResponse.sTATUS).thenReturn("OK")

        projectViewModel.projectResult.value = allProjectsResponse

        projectViewModel.projectResult.value?.let {
            assertEquals(it.sTATUS, "OK")
        }
    }
}
