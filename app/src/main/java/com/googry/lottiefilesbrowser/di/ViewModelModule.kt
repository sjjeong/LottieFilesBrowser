package com.googry.lottiefilesbrowser.di

import com.googry.lottiefilesbrowser.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}