package iam.thevoid.rxe

import io.reactivex.Completable

fun Completable?.safe(action: (() -> Unit)? = null) = this
    ?: action?.let { Completable.fromAction(action) }
    ?: Completable.complete()