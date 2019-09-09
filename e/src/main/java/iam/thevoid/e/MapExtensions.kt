package iam.thevoid.e

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

fun <K, V> MutableMap<K,V>.putAll(vararg data : Pair<K, V>, predicate : (V) -> Boolean) {
    for ((key, value) in data) {
        if (predicate.invoke(value)) {
            put(key, value)
        }
    }
}

fun <K, V> MutableMap<K,V>.putAllIfNotNull(vararg data : Pair<K, V>, predicate : (V) -> Boolean)=
    putAll(*data) { it != null }

fun <K, V : CharSequence?> MutableMap<K,V>.putAllIfNotNullOrEmpty(vararg data : Pair<K, V>)=
    putAll(*data) { it.isNotNullOrEmpty() }

fun <K, V : CharSequence?> MutableMap<K,V>.putAllIfNotNullOrBlank(vararg data : Pair<K, V>)=
    putAll(*data) { it.isNotNullOrBlank() }