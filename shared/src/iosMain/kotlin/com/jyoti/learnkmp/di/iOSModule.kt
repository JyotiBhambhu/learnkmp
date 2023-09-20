package com.jyoti.learnkmp.di

import com.jyoti.learnkmp.network.appModule
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(appModule())
    }
}