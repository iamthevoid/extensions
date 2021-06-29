package iam.thevoid.e


inline fun <reified T> Any?.cast() = this as? T

inline fun <reified T> Any.force() = this as T