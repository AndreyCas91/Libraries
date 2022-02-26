package com.gb.libraries.network

import com.gb.libraries.model.GithubUserModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface GithubApiService {

    @GET("/users")
    fun getUsers(): Single<List<GithubUserModel>>
}