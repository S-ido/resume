package com.chebdowski.resume

import android.app.Application
import com.chebdowski.resume.core.di.applicationModule
import com.chebdowski.resume.core.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@AndroidApplication)
            modules(applicationModule)
            modules(networkModule)
        }
    }
}