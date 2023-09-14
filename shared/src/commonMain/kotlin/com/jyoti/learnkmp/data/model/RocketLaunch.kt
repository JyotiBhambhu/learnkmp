package com.jyoti.learnkmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketLaunch (
    @SerialName("id")
    val id: String?,
    @SerialName("flight_number")
    val flightNumber: Int?,
    @SerialName("name")
    val missionName: String?,
    @SerialName("details")
    val details: String?,
    @SerialName("date_utc")
    val launchDateUTC: String?,
    @SerialName("success")
    val launchSuccess: Boolean?,
    @SerialName("links")
    val links: Links?,
){
    @Serializable
    data class Links(
        @SerialName("patch")
        val patch: Patch?,
    ){
        @Serializable
        data class Patch(
            @SerialName("small")
            val small: String?,
            @SerialName("large")
            val large: String?,
        )
    }
}
