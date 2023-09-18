package com.jyoti.learnkmp.domain

import com.jyoti.learnkmp.data.model.RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Factory

@Factory
class RocketLaunchesUseCase(private val httpClient: HttpClient) {
    @Throws(Exception::class)
    suspend operator fun invoke(): List<RocketLaunch> {

        return httpClient.get("https://api.spacexdata.com/v4/launches").body()

    }
}