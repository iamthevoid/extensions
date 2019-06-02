package iam.thevoid.rxe

import io.reactivex.Flowable
import io.reactivex.functions.BiFunction

/**
 * ZIP
 */

fun <First, Second, Res> Flowable<First>.zipWith(second: Flowable<Second>, zipFun: (First, Second) -> Res): Flowable<Res> =
    zipWith(second, BiFunction { t1, t2 -> zipFun(t1, t2) })

fun <First, Second> Flowable<First>.zipWith(second: Flowable<Second>): Flowable<Pair<First, Second>> =
    zipWith(second) { t1, t2 -> Pair(t1, t2) }