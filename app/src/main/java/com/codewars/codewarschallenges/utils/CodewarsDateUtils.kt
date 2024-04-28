package com.codewars.codewarschallenges.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object CodewarsDateUtils {

    //"2017-02-12T10:29:27.794Z"
    private const val CODEWARS_DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"
    private const val APP_DATE_PATTERN = "yyyy-MM-dd HH:mm"

    fun format(date: String): String {
        val appFormatter = DateTimeFormatter.ofPattern(APP_DATE_PATTERN, Locale.getDefault())
        val codewarsApiFormatter = DateTimeFormatter.ofPattern(CODEWARS_DATE_PATTERN)
        val localDate = LocalDateTime.parse(date, codewarsApiFormatter)

        return localDate.format(appFormatter)
    }
}
