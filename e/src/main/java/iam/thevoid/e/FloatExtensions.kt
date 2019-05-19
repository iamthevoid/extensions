package iam.thevoid.e

fun Float.format(): String =
    if (toLong().toFloat() == this)
        toLong().toString()
    else toString()
