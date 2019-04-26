package com.googry.lottiefilesbrowser.ui.home

import androidx.lifecycle.MutableLiveData
import com.googry.lottiefilesbrowser.base.network.NetworkResponse
import com.googry.lottiefilesbrowser.base.ui.BaseViewModel
import com.googry.lottiefilesbrowser.data.enums.LottieUrl
import com.googry.lottiefilesbrowser.data.source.LottieFileDataSource
import com.googry.lottiefilesbrowser.network.model.LottieInfoResponse
import io.reactivex.rxkotlin.addTo

class HomeViewModel(
    private val lottieFileDataSource: LottieFileDataSource
) : BaseViewModel() {

    val liveLottieInfoItems = MutableLiveData<List<LottieInfoResponse>>()

    init {
        onLoad(0)
    }

    fun onLoad(page: Int) {
        lottieFileDataSource.getLottieInfo(LottieUrl.POPULAR, page + 1, NetworkResponse(
            success = { newData ->
                liveLottieInfoItems.value = liveLottieInfoItems.value?.let {
                    it.toMutableList().apply {
                        addAll(newData)
                    }
                } ?: newData
            }
        )).addTo(compositeDisposable)
    }

}