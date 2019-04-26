package com.googry.lottiefilesbrowser.data.source

import com.googry.lottiefilesbrowser.base.network.NetworkResponse
import com.googry.lottiefilesbrowser.data.enums.LottieUrl
import com.googry.lottiefilesbrowser.ext.networkCommunication
import com.googry.lottiefilesbrowser.network.LottieFileApi
import com.googry.lottiefilesbrowser.network.model.LottieInfoResponse
import io.reactivex.disposables.Disposable

class LottieFileRepository(
    private val lottieFileApi: LottieFileApi
) : LottieFileDataSource {

    override fun getLottieInfo(
        lottieUrl: LottieUrl,
        page: Int,
        networkResponse: NetworkResponse<List<LottieInfoResponse>>
    ): Disposable {
        return lottieFileApi.getLottieInfo(lottieUrl.path, page)
            .networkCommunication()
            .subscribe({
                networkResponse.success?.invoke(it)
            }) {
                networkResponse.failed?.invoke("")
            }
    }

    override fun search(
        query: String,
        page: Int,
        networkResponse: NetworkResponse<List<LottieInfoResponse>>
    ): Disposable {
        return lottieFileApi.search(query, page)
            .networkCommunication()
            .subscribe({
                networkResponse.success?.invoke(it)
            }) {
                networkResponse.failed?.invoke("")
            }
    }
}