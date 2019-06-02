package iam.thevoid.e

import java.util.*

private val millis
    get() = System.currentTimeMillis()

val unixTime
    get() = currentDate.unixTime

val currentDate
    get() = Date(millis)

val currentCalendar: Calendar
    get() = Calendar.getInstance()

val Date.unixTime
    get() = time / 1000

val Date.calendar: Calendar
    get() = Calendar.getInstance().also { it.timeInMillis = time }

fun Date.era() = calendar.era
fun Date.year() = calendar.year
fun Date.month() = calendar.month
fun Date.weekOfYear() = calendar.weekOfYear
fun Date.weekOfMonth() = calendar.weekOfMonth
fun Date.dayOfYear() = calendar.dayOfYear
fun Date.dayOfMonth() = calendar.dayOfMonth
fun Date.dayOfWeek() = calendar.dayOfWeek
fun Date.dayOfWeekInMonth() = calendar.dayOfWeekInMonth
fun Date.hour() = calendar.hour
fun Date.hourOfDay() = calendar.hourOfDay
fun Date.minute() = calendar.minute
fun Date.second() = calendar.second
fun Date.millisecond() = calendar.millisecond