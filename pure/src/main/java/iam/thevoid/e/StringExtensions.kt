package iam.thevoid.e

import org.intellij.lang.annotations.RegExp
import java.util.regex.Pattern

fun String.safeBoolean(default : Boolean = false) = try { toBoolean() } catch (e : Exception) { default }
fun String.safeByte(default : Byte = 0) = toByteOrNull().safe(default)
fun String.safeShort(default : Short = 0) = toShortOrNull().safe(default)
fun String.safeInt(default : Int = 0) = toIntOrNull().safe(default)
fun String.safeLong(default : Long = 0L) = toLongOrNull().safe(default)
fun String.safeFloat(default : Float = 0f) = toFloatOrNull().safe(default)
fun String.safeDouble(default : Double = 0.0) = toDoubleOrNull().safe(default)

@Deprecated("will be removed in next versions")
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
    if (isNullOrBlank()) mapper() else this.safe()

fun <T : CharSequence> T?.ifNullOrEmpty(mapper: () -> T): T =
    if (isNullOrEmpty()) mapper() else this.safe()


fun String.containsAny(vararg containment: String): Boolean = containment.any { contains(it) }

fun String.remove(@RegExp pattern: String) = remove(Regex(pattern, RegexOption.IGNORE_CASE))

fun String.remove(regex: Regex) = replace(regex, "")

fun String.firstOrNull(pattern : String, options : Set<RegexOption> = emptySet()) =
    firstOrNull(Regex(pattern, options))

fun String.firstOrNull(regex : Regex) =
    regex.find(this)?.groups?.firstOrNull()?.value

fun String.first(length: Int) = if (this.length <= length) this else substring(0 until length)