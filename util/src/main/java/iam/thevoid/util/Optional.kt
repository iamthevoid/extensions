package iam.thevoid.util

class Optional<T> private constructor(val item: T?) {

    @get:JvmName("isPresent")
    val present
        get() = item != null

    val notNull
        get() = item!!

    fun orElse(item : T) = this.item ?: item

    companion object {
        @JvmStatic
        fun <T> of(elem: T?): Optional<T> = Optional(elem)

        @JvmStatic
        fun <T> empty(): Optional<T> = Optional(null)
    }
}