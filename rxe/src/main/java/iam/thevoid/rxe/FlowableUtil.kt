@file:JvmName("FlowableUtil")

package iam.thevoid.rxe

import io.reactivex.Flowable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function3
import io.reactivex.functions.Function4
import io.reactivex.functions.Function5
import io.reactivex.functions.Function6
import io.reactivex.functions.Function7
import io.reactivex.functions.Function8
import io.reactivex.functions.Function9
import io.reactivex.rxkotlin.zipWith

/**
 * ZIP
 */

fun <First, Second> zip(first: Flowable<First>, second: Flowable<Second>): Flowable<Pair<First, Second>> =
    first.zipWith(second)

fun <First, Second, Res> zip(
    first: Flowable<First>,
    second: Flowable<Second>,
    zipFun: (First, Second) -> Res
): Flowable<Res> =
    first.zipWith(second, zipFun)

fun <First, Second, Third> zip(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>
): Flowable<Triple<First, Second, Third>> = zip(first, second, third) { t1, t2, t3 -> Triple(t1, t2, t3) }

fun <First, Second, Third, Res> zip(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    zipFun: (First, Second, Third) -> Res
): Flowable<Res> = Flowable.zip(first, second, third, Function3(zipFun))

fun <First, Second, Third, Fourth, Res> zip(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    zipFun: (First, Second, Third, Fourth) -> Res
): Flowable<Res> = Flowable.zip(first, second, third, fourth, Function4(zipFun))

fun <First, Second, Third, Fourth, Fifth, Res> zip(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    zipFun: (First, Second, Third, Fourth, Fifth) -> Res
): Flowable<Res> =
    Flowable.zip(first, second, third, fourth, fifth, Function5(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Res> zip(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    sixth: Flowable<Sixth>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth) -> Res
): Flowable<Res> = Flowable.zip(first, second, third, fourth, fifth, sixth, Function6(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Res> zip(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    sixth: Flowable<Sixth>,
    seventh: Flowable<Seventh>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh) -> Res
): Flowable<Res> = Flowable.zip(first, second, third, fourth, fifth, sixth, seventh, Function7(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight, Res> zip(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    sixth: Flowable<Sixth>,
    seventh: Flowable<Seventh>,
    eight: Flowable<Eight>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight) -> Res
): Flowable<Res> = Flowable.zip(first, second, third, fourth, fifth, sixth, seventh, eight, Function8(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight, Ninth, Res> zip(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    sixth: Flowable<Sixth>,
    seventh: Flowable<Seventh>,
    eight: Flowable<Eight>,
    ninth: Flowable<Ninth>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight, Ninth) -> Res
): Flowable<Res> =
    Flowable.zip(first, second, third, fourth, fifth, sixth, seventh, eight, ninth, Function9(zipFun))

/**
 * COMBINE
 */

fun <First, Second, Res> combine(
    first: Flowable<First>,
    second: Flowable<Second>,
    combFunc: (First, Second) -> Res
): Flowable<Res> = Flowable.combineLatest(first, second, BiFunction(combFunc))

fun <First, Second> combine(
    first: Flowable<First>,
    second: Flowable<Second>
): Flowable<Pair<First, Second>> = combine(first, second) { t1, t2 -> Pair(t1, t2) }

fun <First, Second, Third> combine(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>
): Flowable<Triple<First, Second, Third>> =
    combine(first, second, third) { t1, t2, t3 -> Triple(t1, t2, t3) }

fun <First, Second, Third, Res> combine(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    combFunc: (First, Second, Third) -> Res
): Flowable<Res> = Flowable.combineLatest(first, second, third, Function3(combFunc))

fun <First, Second, Third, Fourth, Res> combine(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    combFunc: (First, Second, Third, Fourth) -> Res
): Flowable<Res> =
    Flowable.combineLatest(first, second, third, fourth, Function4(combFunc))

fun <First, Second, Third, Fourth, Fifth, Res> combine(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    combFunc: (First, Second, Third, Fourth, Fifth) -> Res
): Flowable<Res> = Flowable.combineLatest(first, second, third, fourth, fifth, Function5(combFunc))

fun <First, Second, Third, Fourth, Fifth, Sixth, Res> combine(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    six: Flowable<Sixth>,
    combFunc: (First, Second, Third, Fourth, Fifth, Sixth) -> Res
): Flowable<Res> =
    Flowable.combineLatest(first, second, third, fourth, fifth, six, Function6(combFunc))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Res> combine(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    six: Flowable<Sixth>,
    seventh: Flowable<Seventh>,
    combFunc: (First, Second, Third, Fourth, Fifth, Sixth, Seventh) -> Res
): Flowable<Res> =
    Flowable.combineLatest(first, second, third, fourth, fifth, six, seventh, Function7(combFunc))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Res> combine(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    six: Flowable<Sixth>,
    seventh: Flowable<Seventh>,
    eighth: Flowable<Eighth>,
    combFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth) -> Res
): Flowable<Res> =
    Flowable.combineLatest(first, second, third, fourth, fifth, six, seventh, eighth, Function8(combFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth, Res> combine(
    first: Flowable<First>,
    second: Flowable<Second>,
    third: Flowable<Third>,
    fourth: Flowable<Fourth>,
    fifth: Flowable<Fifth>,
    six: Flowable<Sixth>,
    seventh: Flowable<Seventh>,
    eighth: Flowable<Eighth>,
    ninth: Flowable<Ninth>,
    combFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth) -> Res
): Flowable<Res> =
    Flowable.combineLatest(first, second, third, fourth, fifth, six, seventh, eighth, ninth, Function9(combFun))
