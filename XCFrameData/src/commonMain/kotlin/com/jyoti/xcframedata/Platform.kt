package com.jyoti.xcframedata

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform