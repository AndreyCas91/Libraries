package com.gb.libraries

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class GithubUsersRepo {
    private val repositories =
        (0..100).map { GithubUser("login $it") }

    private val bs = BehaviorSubject.fromIterable(listOf(repositories))

    fun getUsers(): Observable<List<GithubUser>>? {
        return bs
    }

}