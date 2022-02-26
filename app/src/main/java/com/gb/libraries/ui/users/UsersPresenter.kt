package com.gb.libraries.ui.users

import com.gb.libraries.domain.IGithubUsersRepository
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
        router.exit()
        return true
    }

    fun onUserClicked() {
        router.replaceScreen(AppScreens.oneUserScreen())
    }
}