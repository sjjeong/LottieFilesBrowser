package com.googry.lottiefilesbrowser.ext

import android.os.Build
import android.text.Html
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.googry.lottiefilesbrowser.R
import com.googry.lottiefilesbrowser.util.TextViewIntAnimation
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.textColorResource
import org.jetbrains.anko.textSizeDimen
import java.text.SimpleDateFormat

@BindingAdapter(value = ["animInt"])
fun TextView.setAnimInt(value: Int) {
    startAnimation(TextViewIntAnimation(this, to = value))
}

@BindingAdapter(value = ["htmlText"])
fun TextView.setHtmlText(htmlText: String) {
    text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(htmlText)
    }
}

@BindingAdapter(value = ["textColorResId"])
fun TextView.setTextColorResId(resId: Int) {
    textColorResource = resId
}