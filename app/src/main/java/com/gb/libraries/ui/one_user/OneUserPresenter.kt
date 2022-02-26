package com.gb.libraries.ui.one_user

import android.view.View
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter


class OneUserPresenter(private val router: Router) : MvpPresenter(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun backPressed(): Boolean{
        router.backTo(screen.users())
        return true
    }

}