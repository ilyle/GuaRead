package com.xiaoqi.topic.util

import android.text.TextUtils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object TimeUtil {

    fun getTimeStamp(date: String): Long {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA)
        format.timeZone = TimeZone.getTimeZone("UTC")
        return try {
            format.parse(date).time
        } catch (e: ParseException) {
            e.printStackTrace()
            0L
        }
    }

    fun getFormatDateDesc(dateString: String): String {
        if (TextUtils.isEmpty(dateString)) return ""
        val date: Date
        try {
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA)
            format.timeZone = TimeZone.getTimeZone("UTC")
            date = format.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

        var interval: String
        interval = SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA).format(date)

        if (TextUtils.isEmpty(dateString)) return interval
        val currentTimeMillis = System.currentTimeMillis()
        val dateTimeMillis = date.time
        val currCalendar = Calendar.getInstance()//当前日期零点
        currCalendar.timeInMillis = currentTimeMillis
        currCalendar.set(Calendar.HOUR_OF_DAY, 0)
        currCalendar.set(Calendar.MINUTE, 0)
        currCalendar.set(Calendar.SECOND, 0)
        currCalendar.set(Calendar.MILLISECOND, 0)
        val countdownTime = currentTimeMillis - dateTimeMillis
        if (countdownTime < 0) return interval//传入时间早于当前时间
        if (countdownTime / 1000 < 10) {
            interval = "刚刚"
        } else if (countdownTime / 3600000 >= 24) {
            val dateCalendar = Calendar.getInstance()//传入日期零点
            dateCalendar.timeInMillis = dateTimeMillis
            dateCalendar.set(Calendar.HOUR_OF_DAY, 0)
            dateCalendar.set(Calendar.MINUTE, 0)
            dateCalendar.set(Calendar.SECOND, 0)
            dateCalendar.set(Calendar.MILLISECOND, 0)
            val day = ((currCalendar.timeInMillis - dateCalendar.timeInMillis) / 86400000).toInt()
            if (day == 1) {
                interval = "昨天"
            } else if (day > 1) {
                interval = day.toString() + "天前"
            }
        } else if (countdownTime / 3600000 in 1..23) {
            val hour = (countdownTime / 3600000).toInt()
            interval = hour.toString() + "小时前"
        } else if (countdownTime / 60000 in 1..59) {
            val minute = (countdownTime / 60000).toInt()
            interval = minute.toString() + "分钟前"
        } else if (countdownTime / 1000 in 1..59) {
            val second = (countdownTime / 1000).toInt()
            interval = second.toString() + "秒前"
        }
        return interval
    }

    fun getFormatDate(dateString: String): String {
        if (TextUtils.isEmpty(dateString)) return ""
        val date: Date
        try {
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.CHINA)
            format.timeZone = TimeZone.getTimeZone("UTC")
            date = format.parse(dateString)
        } catch (e: ParseException) {
            e.printStackTrace()
            return ""
        }

        return SimpleDateFormat("yyyy年MM月dd日 HH:mm", Locale.CHINA).format(date)
    }
}
