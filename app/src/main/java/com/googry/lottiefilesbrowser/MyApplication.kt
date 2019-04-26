package com.googry.lottiefilesbrowser

import android.app.Application
import com.googry.lottiefilesbrowser.di.dataSourceModule
import com.googry.lottiefilesbrowser.di.networkModule
import com.googry.lottiefilesbrowser.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                viewModelModule,
                networkModule,
                dataSourceModule
            )
        }
    }
}