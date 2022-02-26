package com.gb.libraries.domain

import com.gb.libraries.model.GithubUserModel
import com.gb.libraries.network.GithubApiService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject

class GithubUsersRepo(private val githubApiService: GithubApiService) : IGithubUsersRepository {

    override fun getUsers(): Single<List<GithubUserModel>> {
        return githubApiService.getUsers()
    }
}