package com.example.unioncoop.repository

import com.example.unioncoop.objects.Repo
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Raed Saeed on 30/09/2020.
 */
interface ApiService {
    @GET("repositories")
    fun getRepos() : Observable<List<Repo>>
}