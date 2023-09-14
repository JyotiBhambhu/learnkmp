package com.jyoti.learnkmp.domain

import com.jyoti.learnkmp.data.model.RocketLaunch
import com.jyoti.learnkmp.network.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class RocketLaunchesUseCase {
    @Throws(Exception::class)
    suspend operator fun invoke(): List<RocketLaunch> {

        return httpClient.get("https://api.spacexdata.com/v4/launches").body()

    }
}