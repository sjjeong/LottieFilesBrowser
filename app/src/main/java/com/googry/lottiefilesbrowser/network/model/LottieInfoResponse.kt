package com.googry.lottiefilesbrowser.network.model

data class LottieInfoResponse(
    val id: String = "",
    val dataUrl: String = "",
    val author: String = "",
    val authorProfileUrl: String = "",
    val heartCount: String = "",
    val downloadCount: String = ""
)