@file:JvmName("SingleUtil")

package iam.thevoid.rxe

import io.reactivex.Single
import io.reactivex.functions.Function3
import io.reactivex.functions.Function4
import io.reactivex.functions.Function5
import io.reactivex.functions.Function6
import io.reactivex.functions.Function7
import io.reactivex.functions.Function8
import io.reactivex.functions.Function9

/**
 * ZIP
 */

fun <First, Second> zip(first: Single<First>, second: Single<Second>): Single<Pair<First, Second>> =
    first.zipWith(second)

fun <First, Second, Res> zip(
    first: Single<First>,
    second: Single<Second>,
    zipFun: (First, Second) -> Res
): Single<Res> =
    first.zipWith(second, zipFun)

fun <First, Second, Third> zip(
    first: Single<First>,
    second: Single<Second>,
    third: Single<Third>
): Single<Triple<First, Second, Third>> = zip(first, second, third) { t1, t2, t3 -> Triple(t1, t2, t3) }

fun <First, Second, Third, Res> zip(
    first: Single<First>,
    second: Single<Second>,
    third: Single<Third>,
    zipFun: (First, Second, Third) -> Res
): Single<Res> = Single.zip(first, second, third, Function3(zipFun))

fun <First, Second, Third, Fourth, Res> zip(
    first: Single<First>,
    second: Single<Second>,
    third: Single<Third>,
    fourth: Single<Fourth>,
    zipFun: (First, Second, Third, Fourth) -> Res
): Single<Res> = Single.zip(first, second, third, fourth, Function4(zipFun))

fun <First, Second, Third, Fourth, Fifth, Res> zip(
    first: Single<First>,
    second: Single<Second>,
    third: Single<Third>,
    fourth: Single<Fourth>,
    fifth: Single<Fifth>,
    zipFun: (First, Second, Third, Fourth, Fifth) -> Res
): Single<Res> =
    Single.zip(first, second, third, fourth, fifth, Function5(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Res> zip(
    first: Single<First>,
    second: Single<Second>,
    third: Single<Third>,
    fourth: Single<Fourth>,
    fifth: Single<Fifth>,
    sixth: Single<Sixth>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth) -> Res
): Single<Res> = Single.zip(first, second, third, fourth, fifth, sixth, Function6(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Res> zip(
    first: Single<First>,
    second: Single<Second>,
    third: Single<Third>,
    fourth: Single<Fourth>,
    fifth: Single<Fifth>,
    sixth: Single<Sixth>,
    seventh: Single<Seventh>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh) -> Res
): Single<Res> = Single.zip(first, second, third, fourth, fifth, sixth, seventh, Function7(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight, Res> zip(
    first: Single<First>,
    second: Single<Second>,
    third: Single<Third>,
    fourth: Single<Fourth>,
    fifth: Single<Fifth>,
    sixth: Single<Sixth>,
    seventh: Single<Seventh>,
    eight: Single<Eight>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight) -> Res
): Single<Res> = Single.zip(first, second, third, fourth, fifth, sixth, seventh, eight, Function8(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight, Ninth, Res> zip(
    first: Single<First>,
    second: Single<Second>,
    third: Single<Third>,
    fourth: Single<Fourth>,
    fifth: Single<Fifth>,
    sixth: Single<Sixth>,
    seventh: Single<Seventh>,
    eight: Single<Eight>,
    ninth: Single<Ninth>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight, Ninth) -> Res
): Single<Res> = Single.zip(first, second, third, fourth, fifth, sixth, seventh, eight, ninth, Function9(zipFun))