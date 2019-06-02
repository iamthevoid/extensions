package iam.thevoid.util.groups

/**
 * Created by iam on 09.01.2018.
 */

data class Seven<First, Second, Third, Fourth, Fifth, Sixth, Seventh>(
    val first: First,
    val second: Second,
    val third: Third,
    val fourth: Fourth,
    val fifth: Fifth,
    val sixth: Sixth,
    val seventh: Seventh
)


infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh> First.to(six: Six<Second, Third, Fourth, Fifth, Sixth, Seventh>) =
    six.let { (one, two, three, four, five, six) -> Seven(this, one, two, three, four, five, six) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh> Pair<First, Second>.to(five: Five<Third, Fourth, Fifth, Sixth, Seventh>) =
    five.let { (one, two, three, four, five) -> Seven(first, second, one, two, three, four, five) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh> Triple<First, Second, Third>.to(quad: Quad<Fourth, Fifth, Sixth, Seventh>) =
    quad.let { (one, two, three, four) -> Seven(first, second, third, one, two, three, four) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh> Quad<First, Second, Third, Fourth>.to(triple: Triple<Fifth, Sixth, Seventh>) =
    triple.let { (one, two, three) -> Seven(first, second, third, fourth, one, two, three) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh> Five<First, Second, Third, Fourth, Fifth>.to(pair: Pair<Sixth, Seventh>) =
    pair.let { (one, two) -> Seven(first, second, third, fourth, fifth, one, two) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh> Six<First, Second, Third, Fourth, Fifth, Sixth>.to(item: Seventh) =
    Seven(first, second, third, fourth, fifth, sixth, item)