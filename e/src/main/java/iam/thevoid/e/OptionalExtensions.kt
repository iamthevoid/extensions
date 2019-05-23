package iam.thevoid.e

import java.util.*

val Boolean?.safe: Boolean
    get() = this ?: false

val Byte?.safe: Byte
    get() = this ?: 0

val Short?.safe: Short
    get() = this ?: 0

val Int?.safe: Int
    get() = this ?: 0

val Long?.safe: Long
    get() = this ?: 0

val Float?.safe: Float
    get() = this ?: 0f

val Double?.safe: Double
    get() = this ?: 0.toDouble()

val <T : CharSequence> T?.safe : T
    get() = this ?: "" as T

val IntRange?.safe
    get() = this ?: 0..0

val LongRange?.safe
    get() = this ?: 0..0

inline fun <reified E> Array<E>?.safe(): Array<E> =
        this ?: emptyArray()

val <E> List<E>?.safe: List<E>
    get() = this ?: emptyList()

val <K, V> Map<K, V>?.safe: Map<K, V>
    get() = this ?: emptyMap()

val <E> List<E>?.safeMutable: MutableList<E>
    get() = (if (this is MutableList<E>) this else this?.toMutableList()) ?: mutableListOf()

val <K, V> Map<K, V>?.safeMutable: MutableMap<K, V>
    get() = (if (this is MutableMap<K, V>) this else this?.toMutableMap()) ?: mutableMapOf()

fun CharSequence?.isNotNullOrEmpty() = !isNullOrEmpty()

fun CharSequence?.isNotNullOrBlank() = !isNullOrBlank()

fun <E> List<E>?.isNotNullOrEmpty() =
        this != null && isNotEmpty()

fun <K, V> Map<K, V>?.isNotNullOrEmpty() =
        this != null && isNotEmpty()

fun <T> Optional<T>.nullable() : T? = orElse(null)