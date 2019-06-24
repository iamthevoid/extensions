package iam.thevoid.e

/**
 * SAFE
 */

fun Boolean?.safe(): Boolean = this ?: false

fun Byte?.safe(): Byte = this ?: 0

fun Short?.safe(): Short = this ?: 0

fun Int?.safe(): Int = this ?: 0

fun Long?.safe(): Long = this ?: 0

fun Float?.safe(): Float = this ?: 0f

fun Double?.safe(): Double = this ?: 0.toDouble()

fun <T : CharSequence> T?.safe() : T = this ?: "" as T

fun BooleanArray?.safe() = this ?: booleanArrayOf()

fun ByteArray?.safe() = this ?: byteArrayOf()

fun ShortArray?.safe() = this ?: shortArrayOf()

fun IntArray?.safe() = this ?: intArrayOf()

fun LongArray?.safe() = this ?: longArrayOf()

fun FloatArray?.safe() = this ?: floatArrayOf()

fun DoubleArray?.safe() = this ?: doubleArrayOf()

fun IntRange?.safe() = this ?: 0..0

fun LongRange?.safe() = this ?: 0..0

inline fun <reified E> Array<E>?.safe(): Array<E> =
        this ?: emptyArray()

fun <E> List<E>?.safe(): List<E> = this ?: emptyList()

fun <K, V> Map<K, V>?.safe(): Map<K, V> = this ?: emptyMap()

/**
 * SAFE MUTABLE
 */

fun <E> List<E>?.safeMutable(): MutableList<E> =
    (if (this is MutableList<E>) this else this?.toMutableList()) ?: mutableListOf()

fun <K, V> Map<K, V>?.safeMutable(): MutableMap<K, V> = 
    (if (this is MutableMap<K, V>) this else this?.toMutableMap()) ?: mutableMapOf()

/**
 * CHECKERS
 */

fun CharSequence?.isNotNullOrEmpty() = !isNullOrEmpty()

fun CharSequence?.isNotNullOrBlank() = !isNullOrBlank()

fun <E> List<E>?.isNotNullOrEmpty() = this != null && isNotEmpty()

fun <E> List<E>?.isNullOrEmpty() : Boolean = this == null || isEmpty()

fun <K, V> Map<K, V>?.isNotNullOrEmpty() = this != null && isNotEmpty()

fun <K, V> Map<K, V>?.isNullOrEmpty() = this == null || isEmpty()

fun <T> T?.isNull() = this == null

fun <T> T?.isNotNull() = this != null

/**
 * ACTIONS
 */

fun <T> T?.ifNotNull(toBoolean: T.() -> Boolean) =
    if (this != null) toBoolean() else false
