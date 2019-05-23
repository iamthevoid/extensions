package iam.thevoid.rxe

import io.reactivex.subjects.Subject


fun <T> Subject<T>.canPublish() : Boolean = !hasComplete() && hasThrowable()