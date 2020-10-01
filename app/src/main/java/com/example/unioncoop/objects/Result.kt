package com.example.unioncoop.objects

/**
 * Created by Raed Saeed on 30/09/2020.
 */
@Suppress("UNUSED")
class Result<Any> {
    var status: Status
        private set
    var data: Any? = null
        private set
    var error: Throwable? = null
        private set

    constructor() {
        status = Status.LOADING
    }

    private constructor(status: Status, data: Any, error: Throwable?) {
        this.status = status
        this.data = data
        this.error = error
    }

    fun loading(): Result<Any> {
        status = Status.LOADING
        return this
    }

    fun setData(data: Any): Result<Any> {
        this.data = data
        status = Status.SUCCESS
        return this
    }

    fun setError(error: Throwable?): Result<Any> {
        status = Status.ERROR
        this.error = error
        return this
    }

    enum class Status {
        LOADING, SUCCESS, ERROR
    }

    companion object {
        fun <Any> stateLoading(): Result<Any?> {
            return Result<Any?>(Status.LOADING, null, null)
        }

        fun <Any> stateSuccess(data: Any): Result<Any> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <Any> stateError(throwable: Throwable?): Result<Any?> {
            return Result<Any?>(Status.ERROR, null, throwable)
        }

        fun <Any> stateLoadingWithLocal(data: Any): Result<Any> {
            return Result(Status.LOADING, data, null)
        }
    }
}