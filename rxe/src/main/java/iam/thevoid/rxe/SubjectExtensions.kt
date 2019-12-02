package iam.thevoid.rxe

import io.reactivex.processors.FlowableProcessor
import io.reactivex.subjects.Subject

fun <T> Subject<T>.canPublish(): Boolean = !hasComplete() && !hasThrowable()

fun <T> FlowableProcessor<T>.canPublish(): Boolean = !hasComplete() && !hasThrowable()