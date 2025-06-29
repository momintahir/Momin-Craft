package com.momin.craft

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform