package iam.thevoid.ae

import android.os.Bundle

fun Bundle.asMap() =
    keySet().associateWith { get(it) }