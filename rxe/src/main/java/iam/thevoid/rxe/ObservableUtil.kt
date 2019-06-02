@file:JvmName("ObservableUtil")

package iam.thevoid.rxe

import io.reactivex.Observable
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

fun <First, Second> zip(first: Observable<First>, second: Observable<Second>): Observable<Pair<First, Second>> =
    first.zipWith(second)

fun <First, Second, Res> zip(
    first: Observable<First>,
    second: Observable<Second>,
    zipFun: (First, Second) -> Res
): Observable<Res> =
    first.zipWith(second, zipFun)

fun <First, Second, Third> zip(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>
): Observable<Triple<First, Second, Third>> = zip(first, second, third) { t1, t2, t3 -> Triple(t1, t2, t3) }

fun <First, Second, Third, Res> zip(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    zipFun: (First, Second, Third) -> Res
): Observable<Res> = Observable.zip(first, second, third, Function3(zipFun))

fun <First, Second, Third, Fourth, Res> zip(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    zipFun: (First, Second, Third, Fourth) -> Res
): Observable<Res> = Observable.zip(first, second, third, fourth, Function4(zipFun))

fun <First, Second, Third, Fourth, Fifth, Res> zip(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    zipFun: (First, Second, Third, Fourth, Fifth) -> Res
): Observable<Res> =
    Observable.zip(first, second, third, fourth, fifth, Function5(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Res> zip(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    sixth: Observable<Sixth>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth) -> Res
): Observable<Res> = Observable.zip(first, second, third, fourth, fifth, sixth, Function6(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Res> zip(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    sixth: Observable<Sixth>,
    seventh: Observable<Seventh>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh) -> Res
): Observable<Res> = Observable.zip(first, second, third, fourth, fifth, sixth, seventh, Function7(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight, Res> zip(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    sixth: Observable<Sixth>,
    seventh: Observable<Seventh>,
    eight: Observable<Eight>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight) -> Res
): Observable<Res> = Observable.zip(first, second, third, fourth, fifth, sixth, seventh, eight, Function8(zipFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight, Ninth, Res> zip(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    sixth: Observable<Sixth>,
    seventh: Observable<Seventh>,
    eight: Observable<Eight>,
    ninth: Observable<Ninth>,
    zipFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eight, Ninth) -> Res
): Observable<Res> =
    Observable.zip(first, second, third, fourth, fifth, sixth, seventh, eight, ninth, Function9(zipFun))

/**
 * COMBINE
 */

fun <First, Second, Res> combine(
    first: Observable<First>,
    second: Observable<Second>,
    combFunc: (First, Second) -> Res
): Observable<Res> = Observable.combineLatest(first, second, BiFunction(combFunc))

fun <First, Second> combine(
    first: Observable<First>,
    second: Observable<Second>
): Observable<Pair<First, Second>> = combine(first, second) { t1, t2 -> Pair(t1, t2) }

fun <First, Second, Third> combine(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>
): Observable<Triple<First, Second, Third>> =
    combine(first, second, third) { t1, t2, t3 -> Triple(t1, t2, t3) }

fun <First, Second, Third, Res> combine(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    combFunc: (First, Second, Third) -> Res
): Observable<Res> = Observable.combineLatest(first, second, third, Function3(combFunc))

fun <First, Second, Third, Fourth, Res> combine(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    combFunc: (First, Second, Third, Fourth) -> Res
): Observable<Res> =
    Observable.combineLatest(first, second, third, fourth, Function4(combFunc))

fun <First, Second, Third, Fourth, Fifth, Res> combine(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    combFunc: (First, Second, Third, Fourth, Fifth) -> Res
): Observable<Res> = Observable.combineLatest(first, second, third, fourth, fifth, Function5(combFunc))

fun <First, Second, Third, Fourth, Fifth, Sixth, Res> combine(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    six: Observable<Sixth>,
    combFunc: (First, Second, Third, Fourth, Fifth, Sixth) -> Res
): Observable<Res> =
    Observable.combineLatest(first, second, third, fourth, fifth, six, Function6(combFunc))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Res> combine(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    six: Observable<Sixth>,
    seventh: Observable<Seventh>,
    combFunc: (First, Second, Third, Fourth, Fifth, Sixth, Seventh) -> Res
): Observable<Res> =
    Observable.combineLatest(first, second, third, fourth, fifth, six, seventh, Function7(combFunc))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Res> combine(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    six: Observable<Sixth>,
    seventh: Observable<Seventh>,
    eighth: Observable<Eighth>,
    combFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth) -> Res
): Observable<Res> =
    Observable.combineLatest(first, second, third, fourth, fifth, six, seventh, eighth, Function8(combFun))

fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth, Res> combine(
    first: Observable<First>,
    second: Observable<Second>,
    third: Observable<Third>,
    fourth: Observable<Fourth>,
    fifth: Observable<Fifth>,
    six: Observable<Sixth>,
    seventh: Observable<Seventh>,
    eighth: Observable<Eighth>,
    ninth: Observable<Ninth>,
    combFun: (First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth) -> Res
): Observable<Res> =
    Observable.combineLatest(first, second, third, fourth, fifth, six, seventh, eighth, ninth, Function9(combFun))
