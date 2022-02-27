package com.gb.libraries.ui.users

import com.gb.libraries.domain.users.IGithubUsersRepository
import com.gb.libraries.model.GithubUserModel
import com.gb.libraries.screens.AppScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter


class UsersPresenter(
    private val router: Router,
    private val usersRepository: IGithubUsersRepository
) : MvpPresenter<UsersView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadData()
    }

    private fun loadData() {
        usersRepository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { users ->
                    viewState.updateList(users)
                }, {
                    viewState.showError(it.message)
                }
            )
    }

    fun backPressed(): Boolean {
        return true
    }

    fun onUserClicked(githubUserModel: GithubUserModel) {

        router.navigateTo(AppScreens.oneUserScreen(githubUserModel))
    }
}