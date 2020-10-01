package com.example.unioncoop.repository

import com.example.unioncoop.objects.Repo
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Raed Saeed on 30/09/2020.
 */
class RepoApi @Inject constructor(private val apiService: ApiService) {
    fun getRepo(): Observable<List<Repo>> {
        return apiService.getRepos()
    }
}