package iam.thevoid.coroutines

/**
 * @param delay delay before [block] will be retried
 * @param filter if returns true for [Throwable] then exception will be thrown forward without
 * retry.
 * @param block function which will be retried when [Throwable] thrown after [delay]
 */
suspend fun <T> retryWithDelay(
    delay : Long = 1000,
    filter : (Throwable) -> Boolean = { false },
    block : suspend () -> T
) : T = try {
    block()
} catch (e : Throwable) {

    if (filter(e))
        throw e

    kotlinx.coroutines.delay(delay)

    retryWithDelay(delay, filter, block)
}
