package com.googry.lottiefilesbrowser.di

import com.googry.lottiefilesbrowser.data.source.LottieFileDataSource
import com.googry.lottiefilesbrowser.data.source.LottieFileRepository
import org.koin.dsl.module

val dataSourceModule = module {
    single<LottieFileDataSource> { LottieFileRepository(get()) }
}