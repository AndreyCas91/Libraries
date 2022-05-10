package com.gb.libraries.domain.users

import com.gb.libraries.model.GithubUserModel
import com.gb.libraries.network.GithubApiService
import io.reactivex.rxjava3.core.Single

class GithubUsersRepo(private val githubApiService: GithubApiService) : IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubApiService.getUsers()
    }
}