package com.gb.libraries.ui.one_user

import com.gb.libraries.model.GithubOneUserModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

interface OneUserView : MvpView {

    @AddToEndSingle
    fun updateList(items: List<GithubOneUserModel>)

    @Skip
    fun showError(message: String?)
}