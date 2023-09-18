package com.jyoti.learnkmp.android

import android.app.Application
import com.jyoti.learnkmp.android.di.AndroidModule
import com.jyoti.learnkmp.network.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class MainApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MainApp)
            modules(appModule() + AndroidModule().module)
        }
    }
}