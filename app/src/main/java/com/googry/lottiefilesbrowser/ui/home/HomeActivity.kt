package com.googry.lottiefilesbrowser.ui.home

import android.os.Bundle
import com.googry.lottiefilesbrowser.R
import com.googry.lottiefilesbrowser.base.ui.BaseActivity
import com.googry.lottiefilesbrowser.databinding.HomeActivityBinding
import com.googry.lottiefilesbrowser.ext.replaceFragmentInActivity

class HomeActivity : BaseActivity<HomeActivityBinding>(R.layout.home_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragmentInActivity(HomeFragment.newInstance(), binding.flContainer.id)
    }
}