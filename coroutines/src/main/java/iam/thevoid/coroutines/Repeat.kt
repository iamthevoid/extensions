package iam.thevoid.coroutines

/**
 * function repeatWithDelay repeats [block] until [stopCondition] not satisfied
 * @param delay delay before [block] will be repeated
 * @param stopCondition if returns true for [T] then result of current iteration will be
 * returned, else [block] calculation will be repeated after [delay]
 * @param block function that repeats until [stopCondition] not satisfied
 */
suspend fun <T> repeatWithDelay(
    delay : Long = 1000,
    stopCondition : (T) -> Boolean = { false },
    block : suspend () -> T
) : T  {
    val result = block()
    if (stopCondition(result)) {
        return result
    }
    kotlinx.coroutines.delay(delay)
    return repeatWithDelay(delay, stopCondition, block)
}