package com.kitabeli.hiring.common

import java.text.DecimalFormat
import java.text.NumberFormat

fun Long.toFormattedPrice(): String {
    val formatter: NumberFormat = DecimalFormat("#,###")
    return formatter.format(this)
}