package com.gb.libraries.domain.users

import com.gb.libraries.model.GithubOneUserModel
import com.gb.libraries.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepository {

    fun getUsers(): Single<List<GithubUserModel>>
}