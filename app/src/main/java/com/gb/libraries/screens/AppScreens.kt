package com.gb.libraries.screens

import com.gb.libraries.model.GithubOneUserModel
import com.gb.libraries.model.GithubUserModel
import com.gb.libraries.ui.one_user.OneUserFragment
import com.gb.libraries.ui.repositorie.ReposFragment
import com.gb.libraries.ui.users.UsersFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import java.io.Serializable

object AppScreens {

    fun usersScreen() = FragmentScreen {
        UsersFragment.newInstance()
    }

    fun oneUserScreen(githubUserModel: GithubUserModel) = FragmentScreen {
        OneUserFragment.newInstance(githubUserModel)
    }

    fun ReposScreen(githubOneUserModel: GithubOneUserModel) = FragmentScreen {
        ReposFragment.newInstance(githubOneUserModel)
    }
}