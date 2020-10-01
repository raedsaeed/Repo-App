package com.example.unioncoop.objects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Raed Saeed on 30/09/2020.
 */


class BuiltBy {
    @SerializedName("username")
    @Expose
    var username: String? = null

    @SerializedName("href")
    @Expose
    var href: String? = null

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null
}