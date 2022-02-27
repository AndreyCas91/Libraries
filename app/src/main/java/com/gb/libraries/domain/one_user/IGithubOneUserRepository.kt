package com.gb.libraries.domain.one_user

import com.gb.libraries.model.GithubOneUserModel
import io.reactivex.rxjava3.core.Single

interface IGithubOneUserRepository {

    fun getRepos(url: String): Single<List<GithubOneUserModel>>
}