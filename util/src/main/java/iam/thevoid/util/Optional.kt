package iam.thevoid.util

class Optional<T> private constructor(val elem: T?) {

    @get:JvmName("isPresent")
    val present
        get() = elem != null

    val notNull
        get() = elem!!

    fun orElse(item : T) = elem ?: item

    companion object {
        fun <T> of(elem: T?): Optional<T> = Optional(elem)
        fun <T> empty(): Optional<T> = Optional(null)
    }
}