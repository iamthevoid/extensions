package iam.thevoid.e

import java.util.*

fun <T : Comparable<T>> MutableList<T>.sortedSelf(): MutableList<T> =
        also { sortWith(Comparator { o1, o2 -> o1.compareTo(o2) }) }

inline fun <T, R : Comparable<R>> MutableList<T>.sortedSelf(crossinline selector: (T) -> R?): MutableList<T> =
    also { sortWith(compareBy(selector)) }

val <E> List<E>?.arrayList: ArrayList<E>
    get() = if (this is ArrayList) this else ArrayList(this.safe)
