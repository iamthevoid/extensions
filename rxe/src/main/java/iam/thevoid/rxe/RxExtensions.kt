package iam.thevoid.rxe

import io.reactivex.*
import io.reactivex.disposables.Disposable

fun Disposable?.isNullOrDisposed(): Boolean = this == null || isDisposed

fun Completable.subscribeSafe(onResult: () -> Unit = {}) =
        subscribe(onResult, { it.printStackTrace() })

fun <T> Maybe<T>.subscribeSafe(onResult: (T) -> Unit = {}) =
        subscribe(onResult, { it.printStackTrace() })

fun <T> Single<T>.subscribeSafe(onResult: (T) -> Unit = {}) =
        subscribe(onResult, { it.printStackTrace() })

fun <T> Observable<T>.subscribeSafe(onResult: (T) -> Unit = {}) =
        subscribe(onResult, { it.printStackTrace() })

fun <T> Flowable<T>.subscribeSafe(onResult: (T) -> Unit = {}) =
        subscribe(onResult, { it.printStackTrace() })