package iam.thevoid.rxe

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

fun <T> Observable<T>.toFlowableLatest(): Flowable<T> = toFlowable(BackpressureStrategy.LATEST)
fun <T> Observable<T>.toFlowableBuffer(): Flowable<T> = toFlowable(BackpressureStrategy.BUFFER)
fun <T> Observable<T>.toFlowableDrop(): Flowable<T> = toFlowable(BackpressureStrategy.DROP)
fun <T> Observable<T>.toFlowableError(): Flowable<T> = toFlowable(BackpressureStrategy.ERROR)
fun <T> Observable<T>.toFlowableMissing(): Flowable<T> = toFlowable(BackpressureStrategy.MISSING)

/**
 * ZIP
 */

fun <First, Second, Res> Observable<First>.zipWith(second: Observable<Second>, zipFun: (First, Second) -> Res): Observable<Res> =
    zipWith(second, BiFunction { t1, t2 -> zipFun(t1, t2) })

fun <First, Second> Observable<First>.zipWith(second: Observable<Second>): Observable<Pair<First, Second>> =
    zipWith(second) { t1, t2 -> Pair(t1, t2) }