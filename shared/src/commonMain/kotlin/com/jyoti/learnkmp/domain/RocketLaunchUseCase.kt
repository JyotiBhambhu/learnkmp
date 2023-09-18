package com.jyoti.learnkmp.domain

import com.jyoti.learnkmp.data.model.RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.annotation.Factory

@Factory
class RocketLaunchUseCase(private val httpClient: HttpClient) {
    @Throws(Exception::class)
    suspend operator fun invoke(id: String): RocketLaunch? {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        return rockets.firstOrNull { id == it.id }
    }
}