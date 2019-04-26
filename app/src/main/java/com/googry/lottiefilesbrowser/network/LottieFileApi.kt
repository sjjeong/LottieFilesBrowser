package com.googry.lottiefilesbrowser.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LottieFileApi{
    @GET("/")
    fun getRecent(@Query("page") page: Int): Single<List<LottieInfo>>

    @GET("/popular")
    fun getPopular(@Query("page") page: Int): Single<List<LottieInfo>>

    @GET("/search")
    fun search(@Query("q") query: String): Single<List<LottieInfo>>
}