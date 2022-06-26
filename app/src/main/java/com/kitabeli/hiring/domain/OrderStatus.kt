package com.kitabeli.hiring.domain

enum class OrderStatus(val status: String) {
    CONFIRMED("confirmed"),
    DISPATCHED("dispatched"),
    COMPLETED("completed"),
    CANCELLED("cancelled")
}