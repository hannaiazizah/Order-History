package com.kitabeli.hiring.domain

enum class OrderStatus(val status: String) {
    CONFIRMED("CONFIRMED"),
    DISPATCHED("DISPATCHED"),
    COMPLETED("COMPLETED"),
    CANCELLED("CANCELLED")
}