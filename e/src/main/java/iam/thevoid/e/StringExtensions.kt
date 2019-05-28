package iam.thevoid.e

import org.intellij.lang.annotations.RegExp
import java.util.regex.Pattern

fun String.safeBoolean() = try { toBoolean() } catch (e : Exception) { false }
fun String.safeByte() = toByteOrNull().safe
fun String.safeShort() = toShortOrNull().safe
fun String.safeInt() = toIntOrNull().safe
fun String.safeLong() = toLongOrNull().safe
fun String.safeFloat() = toFloatOrNull().safe
fun String.safeDouble() = toDoubleOrNull().safe

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

fun <T : CharSequence> T?.ifNullOrBlank(mapper: () -> T): T =
    if (isNullOrBlank()) mapper() else this.safe

fun <T : CharSequence> T?.ifNullOrEmpty(mapper: () -> T): T =
    if (isNullOrEmpty()) mapper() else this.safe


fun String.containsAny(vararg containment: String): Boolean = containment.any { contains(it) }

fun String.remove(@RegExp pattern: String) = remove(Regex(pattern, RegexOption.IGNORE_CASE))

fun String.remove(regex: Regex) = replace(regex, "")