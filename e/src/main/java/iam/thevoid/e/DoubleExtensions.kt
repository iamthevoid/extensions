package iam.thevoid.e

fun Double.format(precision : Int? = null): String =
    if (toLong().toDouble() == this)
        toLong().toString()
    else precision?.let { ("%." + (if (it < 0) 0 else it ) + "f").format(this) } ?: toString()