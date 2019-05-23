package iam.thevoid.e

fun Float.format(precision: Int? = null): String =
    if (toLong().toFloat() == this)
        toLong().toString()
    else precision?.let { ("%." + (if (it < 0) 0 else it) + "f").format(this) } ?: toString()
