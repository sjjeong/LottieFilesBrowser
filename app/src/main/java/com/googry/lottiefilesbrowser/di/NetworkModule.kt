package com.googry.lottiefilesbrowser.di

import com.googry.lottiefilesbrowser.BuildConfig
import com.googry.lottiefilesbrowser.network.LottieConverterFactory
import com.googry.lottiefilesbrowser.network.LottieFileApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor.Level.BODY
                } else {
                    HttpLoggingInterceptor.Level.NONE
                }
            })
            .build()
    }

    single {
        LottieConverterFactory() as Converter.Factory
    }

    single {
        RxJava2CallAdapterFactory.create() as CallAdapter.Factory
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://www.lottiefiles.com")
            .client(get())
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .build()
            .create(LottieFileApi::class.java)
    }
}