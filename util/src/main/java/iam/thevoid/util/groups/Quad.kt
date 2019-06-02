package iam.thevoid.util.groups

/**
 * Created by iam on 27.12.2017.
 */

data class Quad<First, Second, Third, Fourth>(
    val first: First,
    val second: Second,
    val third: Third,
    val fourth: Fourth
)

infix fun <First, Second, Third, Fourth> First.to(triple: Triple<Second, Third, Fourth>) =
    triple.let { (one, two, three) -> Quad(this, one, two, three) }

infix fun <First, Second, Third, Fourth> Pair<First, Second>.to(pair: Pair<Third, Fourth>) =
    pair.let { (one, two) -> Quad(first, second, one, two) }

infix fun <First, Second, Third, Fourth> Triple<First, Second, Third>.to(item : Fourth) =
    Quad(first, second, third, item)
