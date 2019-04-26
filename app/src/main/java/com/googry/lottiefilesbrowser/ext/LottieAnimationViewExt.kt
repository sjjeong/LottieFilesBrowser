package com.googry.lottiefilesbrowser.ext

import androidx.databinding.BindingAdapter
import com.airbnb.lottie.LottieAnimationView

@BindingAdapter("loadUrl")
fun LottieAnimationView.loadUrl(url: String) {
    setAnimationFromUrl(url)
}