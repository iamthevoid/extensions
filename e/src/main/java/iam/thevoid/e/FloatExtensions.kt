package iam.thevoid.e

/**
 * @param precision Numbers after point. If there are ending zeroes after point they will be leaved
 * or removed depends on [endingZeroes]
 * @param endingZeroes If false then ending zeroes will be removed else leaved
 */
fun Float.format(precision: Int? = null, endingZeroes: Boolean = false): String =
    if (hasNoFractionalPart()) {
        if (precision != null && endingZeroes) {
            "%.${precision}f".format(this)
        } else {
            integerPart.toString()
        }
    } else {
        precision
            ?.let { ("%." + (if (it < 0) 0 else it) + "f").format(this) }
            ?.let { formatted ->
                formatted.takeIf { endingZeroes }
                    ?: formatted.toFloat().run {
                        when {
                            hasNoFractionalPart() -> integerPart.toString()
                            else -> toString()
                        }
                    }
            }
            ?: toString()
    }

private fun Float.hasNoFractionalPart(): Boolean = toLong().toFloat() == this

private val Float.integerPart: Long
    get() = toLong()

private val Float.fractionalPart: Float
    get() = this - integerPart
