package com.googry.lottiefilesbrowser.network.model

data class LottieInfoResponse(
    val id: String,
    val dataUrl: String,
    val title: String? = null,
    val author: String? = null,
    val authorProfile: String? = null
)