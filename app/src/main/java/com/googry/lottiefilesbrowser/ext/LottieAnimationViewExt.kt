package com.googry.lottiefilesbrowser.ext

import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView
import com.googry.lottiefilesbrowser.network.model.LottieInfoResponse

@BindingAdapter("loadLottie")
fun LottieAnimationView.loadLottie(lottieInfo: LottieInfoResponse) {
    lottieInfo.lottieComposition?.let {
        setComposition(it)
    } ?: run {
        setAnimationFromUrl(lottieInfo.dataUrl)
    }
}