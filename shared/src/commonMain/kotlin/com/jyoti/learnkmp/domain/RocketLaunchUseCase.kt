package com.jyoti.learnkmp.domain

import com.jyoti.learnkmp.data.model.RocketLaunch
import com.jyoti.learnkmp.network.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class RocketLaunchUseCase() {
    @Throws(Exception::class)
    suspend operator fun invoke(id: String): RocketLaunch? {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        return rockets.firstOrNull { id == it.id }
    }
}