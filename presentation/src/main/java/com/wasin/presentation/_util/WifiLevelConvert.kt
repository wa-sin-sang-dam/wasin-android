package com.wasin.presentation._util

import com.wasin.presentation.R


fun getWifi(level: Int): Int {
    return when (level) {
        4 -> R.drawable.wifi1
        3 -> R.drawable.wifi2
        2 -> R.drawable.wifi3
        else -> R.drawable.wifi4
    }
}

fun getWifiLevel(level: Long): Long {
    if (level >= -50) {
        return 4
    }
    if (level >= -70) {
        return 3
    }
    if (level >= -80) {
        return 2
    }
    return 1
}
