package com.gb.libraries.domain.one_user

import com.gb.libraries.model.GithubOneUserModel
import com.gb.libraries.network.GithubApiService
import io.reactivex.rxjava3.core.Single

class GithubOneUserRepo(private val githubApiService: GithubApiService) : IGithubOneUserRepository {
    override fun getRepos(url: String): Single<List<GithubOneUserModel>> {
        return githubApiService.getRepos(url)
    }

}