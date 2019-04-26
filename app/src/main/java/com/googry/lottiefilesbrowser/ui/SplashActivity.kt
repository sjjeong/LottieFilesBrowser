package com.googry.lottiefilesbrowser.ui

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.googry.lottiefilesbrowser.R
import com.googry.lottiefilesbrowser.ui.home.HomeActivity
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            startActivity<HomeActivity>()
            finish()
        }, 0)
    }
}
