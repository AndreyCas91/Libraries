package com.gb.libraries

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class OneUserPresenter(private val router: Router, val screen: IScreens) : MvpPresenter<UserView>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backPressed(): Boolean{
        router.backTo(screen.users())
        return true
    }

}