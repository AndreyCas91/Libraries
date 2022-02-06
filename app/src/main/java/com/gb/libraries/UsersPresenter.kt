package com.gb.libraries

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class UsersPresenter(val usersRepo: GithubUsersRepo, val router: Router, val screen: IScreens) : MvpPresenter<UsersView>(){
    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null
        override fun getCount() = users.size
        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = {

            val name = usersListPresenter.users[it.pos].login

            router.navigateTo(screen.user(name))
        }
    }

    fun loadData() {

        val users = usersRepo.getUsers()
        users?.subscribe(){
            usersListPresenter.users.addAll(it)
        }
        viewState.updateList()
    }

    fun backPressed(): Boolean{
        return true
    }

}