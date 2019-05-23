package iam.thevoid.e

import org.intellij.lang.annotations.RegExp
import java.util.regex.Pattern

fun String.safeByte() = safe { toByte() }
fun String.safeShort() = safe { toShort() }
fun String.safeInt() = safe { toInt() }
fun String.safeLong() = safe { toLong() }
fun String.safeFloat() = safe { toFloat() }
fun String.safeDouble() = safe { toDouble() }

private inline fun <reified T : Number> String.safe(mapper: String.() -> T) : T = try {
    mapper()
} catch (e: Exception) {
    0 as T
}

val String?.extractDouble: Double
    get() = if (this == null) 0.toDouble() else Pattern.compile("\\.?\\d+(\\.\\d+)?").matcher(this).let {
        if (it.find()) ("0${it.group(0)}").toDouble() else 0.toDouble()
    }

fun String.ifBlank(mapper: () -> String): String =
    if (isBlank()) mapper() else this

fun String.ifEmpty(mapper: () -> String): String =
    if (isEmpty()) mapper() else this

fun String?.ifNull(mapper: () -> String): String =
    this ?: mapper()

fun String?.ifNullOrBlank(mapper: () -> String): String =
    if (isNullOrBlank()) mapper() else this.safe

fun String?.ifNullOrEmpty(mapper: () -> String): String =
    if (isNullOrEmpty()) mapper() else this.safe


fun String.containsAny(vararg containment: String): Boolean = containment.any { contains(it) }

fun String.remove(@RegExp pattern: String) = remove(Regex(pattern, RegexOption.IGNORE_CASE))

fun String.remove(regex: Regex) = replace(regex, "")