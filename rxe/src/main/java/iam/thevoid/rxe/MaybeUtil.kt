@file:JvmName("MaybeUtil")

package iam.thevoid.rxe

import io.reactivex.Maybe

fun <T> T.toMaybe() = Maybe.just(this)