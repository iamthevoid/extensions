package iam.thevoid.ae

import java.util.regex.Pattern

val String?.safeDouble: Double
    get() = if (this == null) 0.toDouble() else Pattern.compile("\\.?\\d+(\\.\\d+)?").matcher(this).let {
        if (it.find()) ("0${it.group(0)}").toDouble() else 0.toDouble()
    }