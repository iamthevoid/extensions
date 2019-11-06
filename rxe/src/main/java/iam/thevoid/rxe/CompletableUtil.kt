@file:JvmName("CompleteableUtil")

package iam.thevoid.rxe

import io.reactivex.Completable
import io.reactivex.Single

fun <T> Completable.toSingle(item : () -> T) = andThen(Single.just(item()))