package iam.thevoid.util.groups

/**
 * Created by iam on 09.01.2018.
 */

data class Eight<First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth>(
    val first: First,
    val second: Second,
    val third: Third,
    val fourth: Fourth,
    val fifth: Fifth,
    val sixth: Sixth,
    val seventh: Seventh,
    val eighth: Eighth
)


infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth> First.to(seven: Seven<Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth>) =
    seven.let { (one, two, three, four, five, six, seven) -> Eight(this, one, two, three, four, five, six, seven) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth> Pair<First, Second>.to(six: Six<Third, Fourth, Fifth, Sixth, Seventh, Eighth>) =
    six.let { (one, two, three, four, five, six) -> Eight(first, second, one, two, three, four, five, six) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth> Triple<First, Second, Third>.to(five: Five<Fourth, Fifth, Sixth, Seventh, Eighth>) =
    five.let { (one, two, three, four, five) -> Eight(first, second, third, one, two, three, four, five) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth> Quad<First, Second, Third, Fourth>.to(quad: Quad<Fifth, Sixth, Seventh, Eighth>) =
    quad.let { (one, two, three, four) -> Eight(first, second, third, fourth, one, two, three, four) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth> Five<First, Second, Third, Fourth, Fifth>.to(triple: Triple<Sixth, Seventh, Eighth>) =
    triple.let { (one, two, three) -> Eight(first, second, third, fourth, fifth, one, two, three) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth> Six<First, Second, Third, Fourth, Fifth, Sixth>.to(pair: Pair<Seventh, Eighth>) =
    pair.let { (one, two) -> Eight(first,second, third, fourth, fifth, sixth, one, two) }

infix fun <First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth> Seven<First, Second, Third, Fourth, Fifth, Sixth, Seventh>.to(item : Eighth) =
    Eight(first,second, third, fourth, fifth, sixth, seventh, item)