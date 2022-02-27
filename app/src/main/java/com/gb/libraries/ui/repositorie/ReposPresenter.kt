package com.gb.libraries.ui.repositorie

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class ReposPresenter(
    private val router: Router
): MvpPresenter<ReposView>() {

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}