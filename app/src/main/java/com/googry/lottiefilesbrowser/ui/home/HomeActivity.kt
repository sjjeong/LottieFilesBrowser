package com.googry.lottiefilesbrowser.ui.home

import android.os.Bundle
import com.dino.library.ext.replaceFragmentInActivity
import com.dino.library.ui.BaseActivity
import com.googry.lottiefilesbrowser.R
import com.googry.lottiefilesbrowser.databinding.HomeActivityBinding

class HomeActivity : BaseActivity<HomeActivityBinding>(R.layout.home_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceFragmentInActivity(HomeFragment.newInstance(), binding.flContainer.id)
    }
}