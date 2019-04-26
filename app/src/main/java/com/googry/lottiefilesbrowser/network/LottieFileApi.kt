package com.googry.lottiefilesbrowser.network

import com.googry.lottiefilesbrowser.network.model.LottieInfoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LottieFileApi {
    @GET("/{path}")
    fun getLottieInfo(
        @Path("path") path: String,
        @Query("page") page: Int
    ): Single<List<LottieInfoResponse>>

    @GET("/search")
    fun search(
        @Query("q") query: String,
        @Query("page") page: Int
    ): Single<List<LottieInfoResponse>>
}