package com.chebdowski.resume.di

import com.chebdowski.data.PersonApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single { provideOkHttpClient() }
    single { providePersonApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient.Builder().addInterceptor(interceptor).build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://gist.githubusercontent.com/S-ido/323a2c129412a82481ef3e5f72c7c902/raw/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun providePersonApi(retrofit: Retrofit): PersonApi = retrofit.create(PersonApi::class.java)