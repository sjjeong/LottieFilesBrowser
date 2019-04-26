package com.googry.lottiefilesbrowser.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["loadUrl"])
fun ImageView.loadUrl(url: String?) {
    url?.let {
        Glide.with(this)
            .load(it)
            .thumbnail(0.1f)
            .into(this)
    }
}

@BindingAdapter(value = ["drawableResId"])
fun ImageView.setDrawableResId(resId: Int) {
    setImageResource(resId)
}