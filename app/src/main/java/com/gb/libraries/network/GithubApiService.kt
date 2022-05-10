package com.gb.libraries.network

import com.gb.libraries.model.GithubOneUserModel
import com.gb.libraries.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface GithubApiService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>

    @GET
    fun getRepos(@Url url: String): Single<List<GithubOneUserModel>>
}