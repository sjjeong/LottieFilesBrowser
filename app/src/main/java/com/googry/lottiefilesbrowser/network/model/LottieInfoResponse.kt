package com.googry.lottiefilesbrowser.network.model

import com.airbnb.lottie.LottieComposition

data class LottieInfoResponse(
    val id: String = "",
    val dataUrl: String = "",
    val author: String = "",
    val authorProfileUrl: String = "",
    val heartCount: String = "",
    val downloadCount: String = "",
    var lottieComposition: LottieComposition? = null,
    var height: Int = 0
)