package com.googry.lottiefilesbrowser.data.source

import com.googry.lottiefilesbrowser.base.network.NetworkResponse
import com.googry.lottiefilesbrowser.data.enums.LottieUrl
import com.googry.lottiefilesbrowser.network.model.LottieInfoResponse
import io.reactivex.disposables.Disposable

interface LottieFileDataSource {

    fun getLottieInfo(
        lottieUrl: LottieUrl,
        page: Int,
        networkResponse: NetworkResponse<List<LottieInfoResponse>>
    ): Disposable

    fun search(
        query: String,
        page: Int,
        networkResponse: NetworkResponse<List<LottieInfoResponse>>
    ): Disposable
}