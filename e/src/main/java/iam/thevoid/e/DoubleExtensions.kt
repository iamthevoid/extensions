package iam.thevoid.e

/**
 * @param precision Numbers after point. If there are 0(s) after point in end they will be leaved
 * or removed depends on [endingZeroes]
 * @param endingZeroes If false then ending zeroes will be removed else leaved
 */
fun Double.format(precision: Int? = null, endingZeroes: Boolean = false): String =
    if (toLong().toDouble() == this) {
        if (precision != null && endingZeroes) {
            "%.${precision}f".format(this)
        } else {
            toLong().toString()
        }
    } else {
        precision
            ?.let { ("%." + (if (it < 0) 0 else it) + "f").format(this) }
            ?.let { if (endingZeroes) it else it.toFloat().toString() }
            ?: toString()
    }