package iam.thevoid.e

/**
 * @param precision Numbers after point. If there are 0(s) after point in end they will be leaved
 * or removed depends on [endingZeroes]
 * @param endingZeroes If false then ending zeroes will be removed else leaved
 */
fun Double.format(precision: Int? = null, endingZeroes: Boolean = false): String =
    if (hasNoFractionalPart()) {
        if (precision != null && endingZeroes) {
            "%.${precision}f".format(this)
        } else {
            integerPart.toString()
        }
    } else {
        precision
            ?.let { ("%." + (if (it < 0) 0 else it) + "f") }
            ?.format(this)
            ?.replace(",", ".")
            ?.trim()
            ?.let { formatted ->
                formatted.takeIf { endingZeroes }
                    ?: formatted.toDoubleOrNull()?.run {
                        when {
                            hasNoFractionalPart() -> integerPart.toString()
                            else -> toString()
                        }
                    }
            }
            ?: toString()
    }

private fun Double.hasNoFractionalPart(): Boolean = toLong().toDouble() == this

private val Double.integerPart: Long
    get() = toLong()

private val Double.fractionalPart: Double
    get() = this - integerPart