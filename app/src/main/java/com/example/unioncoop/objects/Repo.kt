package com.example.unioncoop.objects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Raed Saeed on 30/09/2020.
 */


class Repo : BaseObject() {
    @SerializedName("author")
    @Expose
    var author: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("language")
    @Expose
    var language: String? = null

    @SerializedName("languageColor")
    @Expose
    var languageColor: String? = null

    @SerializedName("stars")
    @Expose
    var stars = 0

    @SerializedName("forks")
    @Expose
    var forks = 0

    @SerializedName("currentPeriodStars")
    @Expose
    var currentPeriodStars = 0

    @SerializedName("builtBy")
    @Expose
    var builtBy: List<BuiltBy>? = null
}