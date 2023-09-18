package com.jyoti.learnkmp.android.di

import androidx.activity.ComponentActivity
import com.jyoti.learnkmp.android.feature.detail.DetailViewModel
import com.jyoti.learnkmp.android.feature.launch.LaunchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.ksp.generated.module

fun androidModule() = listOf(AndroidModule().module)
@Module
@ComponentScan("com.jyoti.learnkmp.android")
class AndroidModule {
    @Factory
    fun provideLaunchViewModel(activity: ComponentActivity): LaunchViewModel {
        val launchViewModel: LaunchViewModel by activity.viewModel()
        return launchViewModel
    }

    @Factory
    fun provideDetailViewModel(activity: ComponentActivity): DetailViewModel {
        val launchViewModel: DetailViewModel by activity.viewModel()
        return launchViewModel
    }
}