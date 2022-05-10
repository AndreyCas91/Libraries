package com.gb.libraries

import com.gb.libraries.domain.users.IGithubUsersRepository
import com.gb.libraries.network.ApiHolder
import com.gb.libraries.ui.users.UsersPresenter
import com.gb.libraries.ui.users.UsersView
import com.nhaarman.mockito_kotlin.atMost
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Test

class TestUsersPresenter {
    private val userRepo = mock<IGithubUsersRepository>()

    private val userView = mock<UsersView>()

    private val presenter = UsersPresenter(userView, userRepo)

    @Test
    fun testMainPresenterRepos() {

        presenter.loadData()
        verify(userRepo, atMost(1)).getUsers()
    }

    @Test
    fun testMainPresenter() {

        presenter.loadData()
        Assert.assertNotNull(ApiHolder.githubApiService)
    }

}
