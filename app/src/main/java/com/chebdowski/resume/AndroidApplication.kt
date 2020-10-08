package com.chebdowski.resume

import android.app.Application
import com.chebdowski.resume.di.applicationModule
import com.chebdowski.resume.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@AndroidApplication)
            modules(applicationModule)
            modules(networkModule)
        }
    }
}