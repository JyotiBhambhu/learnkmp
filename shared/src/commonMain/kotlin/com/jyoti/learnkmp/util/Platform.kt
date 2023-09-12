package com.jyoti.learnkmp.util

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform