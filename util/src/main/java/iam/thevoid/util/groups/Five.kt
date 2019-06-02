package iam.thevoid.util.groups

/**
 * Created by iam on 28.12.2017.
 */

data class Five<First, Second, Third, Fourth, Fifth>(
    val first: First,
    val second: Second,
    val third: Third,
    val fourth: Fourth,
    val fifth: Fifth
)

infix fun <First, Second, Third, Fourth, Fifth> First.to(quad: Quad<Second, Third, Fourth, Fifth>) =
    quad.let { (one, two, three, four) -> Five(this, one, two, three, four) }

infix fun <First, Second, Third, Fourth, Fifth> Pair<First, Second>.to(triple: Triple<Third, Fourth, Fifth>) =
    triple.let { (one, two, three) -> Five(first, second, one, two, three) }

infix fun <First, Second, Third, Fourth, Fifth> Triple<First, Second, Third>.to(pair: Pair<Fourth, Fifth>) =
    pair.let { (one, two) -> Five(first, second, third, one, two) }

infix fun <First, Second, Third, Fourth, Fifth> Quad<First, Second, Third, Fourth>.to(item : Fifth) =
    Five(first, second, third, fourth, item)
