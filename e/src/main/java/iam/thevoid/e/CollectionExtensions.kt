package iam.thevoid.e

import java.util.*


inline fun <E> Iterable<E>.forEachApply(action: E.() -> Unit): Unit {
    for (element in this) element.action()
}

inline fun <E> Iterable<E>.forEachApplyIndexed(action: E.(index: Int) -> Unit) {
    var index = 0
    for (item in this) item.action(index++)
}

/**
 * SET
 */

fun <T> Set<T>?.isEmpty(): Boolean = if (this == null) true else isEmpty()

/**
 * MAP
 */

fun <K, V> Map<K, List<V>>.flatten(): List<Any?> =
    map { (k, v) ->
        mutableListOf<Any?>().apply {
            add(k)
            addAll(v)
        }
    }.flatten()

fun <K, V> Map<K, List<V>>.indexInSection(element: V): Int {
    forEach { (_, list) -> if (list.contains(element)) return list.indexOf(element) }
    return -1
}

fun <K, V> Map<K, List<V>>.keyIndex(key: K?): Int {
    key ?: return -1
    var index = 0
    forEach { (k, _) -> if (key == k) return index else index++ }
    return -1
}

fun <K, V> Map<K, List<V>>.keyAtIndex(index: Int): K? {
    keys.forEachIndexed { ind, k -> if (ind == index) return k }
    return null
}

fun <K, V> Map<K, List<V>>.sectionKey(element: V): K? {
    forEach { (k, list) -> if (list.contains(element)) return k }
    return null
}

/**
 * LIST
 */

fun <T> T.mergeWith(items: Iterable<T>)  =
    mutableListOf(this).apply { addAll(items) }

fun <T> T.mergeWith(vararg items: T) =
    mutableListOf(this).apply { addAll(items) }

fun <E : Comparable<E>> MutableList<E>.sortedSelf(): MutableList<E> =
    also { sortWith(Comparator { o1, o2 -> o1.compareTo(o2) }) }

inline fun <E, R : Comparable<R>> MutableList<E>.sortedSelf(crossinline selector: (E) -> R?): MutableList<E> =
    also { sortWith(compareBy(selector)) }

fun <T> MutableList<T>.swap(from: Int, to: Int) {
    val buffer = this[from]
    this[from] = this[to]
    this[to] = buffer
}

val <E> List<E>?.arrayList: ArrayList<E>
    get() = if (this is ArrayList) this else ArrayList(safe)

fun <E> List<E>.indexOf(item: E?): Int = if (item == null) -1 else indexOf(item)

fun <E> List<E>.isLast(element: E): Boolean = indexOf(element) == size - 1

fun <E> List<E>.nextAfter(index: Int): E? = if (index == count() - 1) null else this[index + 1]

fun <E> List<E>.nextAfter(element: E): E? =
    when (val index = indexOf(element)) {
        -1 -> throw IllegalAccessException("List doesn't contains $element")
        size - 1 -> null
        else -> this[index + 1]
    }

fun <E> List<E>.prevBefore(index: Int): E? = if (index == 0) null else this[index - 1]

fun <E> List<E>.prevBefore(element: E): E? =
    when (val index = indexOf(element)) {
        -1 -> throw IllegalAccessException("List doesn't contains $element")
        0 -> null
        else -> this[index - 1]
    }