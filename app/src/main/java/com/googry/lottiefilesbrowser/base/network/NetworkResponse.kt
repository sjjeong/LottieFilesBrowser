package com.googry.lottiefilesbrowser.base.network

class NetworkResponse<T>(
    var success: ((response: T) -> Unit)? = null,
    var failed: ((errorCode: String) -> Unit)? = null
)