package iam.thevoid.util.groups

/**
 * Created by iam on 09.01.2018.
 */

data class Nine<First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth>(
    val first: First,
    val second: Second,
    val third: Third,
    val fourth: Fourth,
    val fifth: Fifth,
    val sixth: Sixth,
    val seventh: Seventh,
    val eighth: Eighth,
    val ninth : Ninth
)

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth> First.to(eight: Eight<Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth>) =
    eight.let { (one, two, three, four, five, six, seven, eight) -> Nine(this, one, two, three, four, five, six, seven, eight) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth> Pair<First, Second>.to(seven: Seven<Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth>) =
    seven.let { (one, two, three, four, five, six, seven) -> Nine(first, second, one, two, three, four, five, six, seven) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth> Triple<First, Second, Third>.to(six: Six<Fourth, Fifth, Sixth, Seventh, Eighth, Ninth>) =
    six.let { (one, two, three, four, five, six) -> Nine(first, second, third,  one, two, three, four, five, six) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth> Quad<First, Second, Third, Fourth>.to(five: Five<Fifth, Sixth, Seventh, Eighth, Ninth>) =
    five.let { (one, two, three, four, five) -> Nine(first, second, third, fourth,  one, two, three, four, five) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth> Five<First, Second, Third, Fourth, Fifth>.to(quad: Quad<Sixth, Seventh, Eighth, Ninth>) =
    quad.let { (one, two, three, four) -> Nine(first, second, third, fourth, fifth,  one, two, three, four) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth> Six<First, Second, Third, Fourth, Fifth, Sixth>.to(triple: Triple<Seventh, Eighth, Ninth>) =
    triple.let { (one, two, three) -> Nine(first, second, third, fourth, fifth, sixth,  one, two, three) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth> Seven<First, Second, Third, Fourth, Fifth, Sixth, Seventh>.to(pair: Pair< Eighth, Ninth>) =
    pair.let { (one, two) -> Nine(first, second, third, fourth, fifth, sixth, seventh,  one, two) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth, Ninth> Eight<First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth>.to(item : Ninth) =
    Nine(first, second, third, fourth, fifth, sixth, seventh,  eighth, item)
