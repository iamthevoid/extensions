package iam.thevoid.util.groups

/**
 * Created by iam on 09.01.2018.
 */

data class Six<First, Second, Third, Fourth, Fifth, Sixth>(
    val first: First,
    val second: Second,
    val third: Third,
    val fourth: Fourth,
    val fifth: Fifth,
    val sixth: Sixth
)

infix fun <First, Second, Third, Fourth, Fifth, Sixth> First.to(five: Five<Second, Third, Fourth, Fifth, Sixth>) =
    five.let { (one, two, three, four, five) -> Six(this, one, two, three, four, five) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth> Pair<First, Second>.to(quad: Quad<Third, Fourth, Fifth, Sixth>) =
    quad.let { (one, two, three, four) -> Six(first, second, one, two, three, four) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth> Triple<First, Second, Third>.to(triple: Triple<Fourth, Fifth, Sixth>) =
    triple.let { (one, two, three) -> Six(first, second, third, one, two, three) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth> Quad<First, Second, Third, Fourth>.to(pair: Pair<Fifth, Sixth>) =
    pair.let { (one, two) -> Six(first, second, third, fourth, one, two) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth> Five<First, Second, Third, Fourth, Fifth>.to(item: Sixth) =
    Six(first, second, third, fourth, fifth, item)