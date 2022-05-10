package com.gb.libraries.ui.one_user

import com.gb.libraries.domain.one_user.IGithubOneUserRepository
import com.gb.libraries.model.GithubOneUserModel
import com.gb.libraries.model.GithubUserModel
import com.gb.libraries.screens.AppScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter


class OneUserPresenter(
    private val router: Router,
    private val oneUserRepository: IGithubOneUserRepository,
    private val initUser: GithubUserModel
) : MvpPresenter<OneUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        oneUserRepository.getRepos(initUser.reposUrl!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({repos ->
                viewState.updateList(repos)
            }, {
                viewState.showError(it.message)
            })
    }

    fun backPressed(): Boolean {
        router.backTo(AppScreens.usersScreen())
        return true
    }

    fun onReposClicked(githubOneUserModel: GithubOneUserModel) {
        router.navigateTo(AppScreens.ReposScreen(githubOneUserModel))
    }

}