package iam.thevoid.rxe

import io.reactivex.Single
import io.reactivex.functions.BiFunction

fun <T> Single<T>.toFlowableLatest() = toObservable().toFlowableLatest()
fun <T> Single<T>.toFlowableBuffer() = toObservable().toFlowableBuffer()
fun <T> Single<T>.toFlowableDrop() = toObservable().toFlowableDrop()
fun <T> Single<T>.toFlowableError() = toObservable().toFlowableError()
fun <T> Single<T>.toFlowableMissing() = toObservable().toFlowableMissing()

/**
 * ZIP
 */

fun <First, Second, Res> Single<First>.zipWith(second: Single<Second>, zipFun: (First, Second) -> Res): Single<Res> =
    zipWith(second, BiFunction { t1, t2 -> zipFun(t1, t2) })

fun <First, Second> Single<First>.zipWith(second: Single<Second>): Single<Pair<First, Second>> =
    zipWith(second) { t1, t2 -> Pair(t1, t2) }

fun <T, R> Single<T>.mapSelf(mapper : T.() -> R) = map { it.mapper() }
