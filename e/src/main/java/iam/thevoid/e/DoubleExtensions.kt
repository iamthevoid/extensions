package iam.thevoid.e

fun Double.format(): String =
    if (toLong().toDouble() == this)
        toLong().toString()
    else toString()