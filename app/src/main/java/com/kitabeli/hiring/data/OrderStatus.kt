package com.kitabeli.hiring.data

enum class OrderStatus(val status: String) {
    CONFIRMED("confirmed"),
    DISPATCHED("dispatched"),
    COMPLETED("completed"),
    CANCELLED("cancelled")
}