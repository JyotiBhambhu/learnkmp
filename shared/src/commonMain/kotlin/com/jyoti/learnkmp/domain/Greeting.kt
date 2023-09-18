package com.jyoti.learnkmp.domain

import com.jyoti.learnkmp.data.model.RocketLaunch
import com.jyoti.learnkmp.date.daysUntilNewYear
import com.jyoti.learnkmp.util.Platform
import com.jyoti.learnkmp.util.getPlatform
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class Greeting(private val httpClient: HttpClient) {
    private val platform: Platform = getPlatform()
    @Throws(Exception::class)
    suspend fun greet(): String {
        val rockets: List<RocketLaunch> =
            httpClient.get("https://api.spacexdata.com/v4/launches").body()
        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }

        return "Guess what it is! > ${platform.name.reversed()}!" +
                "\nThere are only ${daysUntilNewYear()} left until New Year! 🎆" +
                "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} 🚀"

    }
}