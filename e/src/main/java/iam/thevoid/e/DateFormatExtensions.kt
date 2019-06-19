package iam.thevoid.e

import java.text.DateFormat
import java.text.ParseException
import java.util.*

fun DateFormat.parseSafe(date: String, onFail: () -> Date = { Date(0L) }) : Date = try {
    parse(date)
} catch (e: ParseException) {
    onFail.invoke()
}