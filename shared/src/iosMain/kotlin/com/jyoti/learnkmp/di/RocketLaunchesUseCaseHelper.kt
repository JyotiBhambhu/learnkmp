package com.jyoti.learnkmp.di

import com.jyoti.data.model.RocketLaunch
import com.jyoti.learnkmp.domain.RocketLaunchesUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RocketLaunchesUseCaseHelper: KoinComponent {
    private val launchesUseCase : RocketLaunchesUseCase by inject()
    suspend operator fun invoke() : List<RocketLaunch> = launchesUseCase.invoke()
}