package com.bayudevkt.materialandroidfordevelopers.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateHelper {

    fun formatTime(timeInMills: Long?, pattern: String = "yyyy MMM dd"): String {
        if (timeInMills == null) return "Invalid Date"
        val format = SimpleDateFormat(pattern, Locale.getDefault())
        return format.format(Date(timeInMills))
    }
}