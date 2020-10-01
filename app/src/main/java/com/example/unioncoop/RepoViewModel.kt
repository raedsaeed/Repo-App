package com.example.unioncoop

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unioncoop.objects.Repo
import com.example.unioncoop.objects.Result
import com.example.unioncoop.repository.RepoApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Raed Saeed on 30/09/2020.
 */
class RepoViewModel @Inject constructor(private val repoApi: RepoApi) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    private val repoData = MutableLiveData<Result<List<Repo>>>()
    private val repoResult = Result<List<Repo>>()


    fun fetchRepos() {
        compositeDisposable.add(repoApi.getRepo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { repoData.postValue(repoResult.loading()) }
            .subscribe({ repos -> repoData.postValue(repoResult.setData(repos)) }, { error ->
                repoData.postValue(repoResult.setError(error))
            })
        )
    }

    fun getRepoData(): MutableLiveData<Result<List<Repo>>> {
        return repoData
    }
}