package com.kitabeli.hiring.common

import android.annotation.SuppressLint
import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("SimpleDateFormat")
fun String.getFormattedDate(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val parsedDate = LocalDateTime.parse(this, dtf)
        parsedDate.format(DateTimeFormatter.ofPattern("EEE, dd MMM yyyy"))
    } else {
        val parser =  SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val formatter = SimpleDateFormat("EEE, dd MMM yyyy")
        formatter.format(parser.parse(this))
    }
}