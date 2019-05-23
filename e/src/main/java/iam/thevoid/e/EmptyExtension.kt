package iam.thevoid.e

fun <T : CharSequence> T?.orElse(item: T) =
    if (this != null && isNotBlank()) this else item

fun Byte?.orElse(byte: Byte) =
    if (this != null && this != 0.toByte()) this else byte

fun Short?.orElse(short: Short) =
    if (this != null && this != 0.toShort()) this else short

fun Int?.orElse(int : Int) =
    if (this != null && this != 0) this else int

fun Long?.orElse(long : Long) =
    if (this != null && this != 0L) this else long

fun Float?.orElse(float : Float) =
    if (this != null && this != 0f) this else float

fun Double?.orElse(double : Double) =
    if (this != null && this != 0.toDouble()) this else double

fun <T> List<T>?.orElse(list : List<T>) =
    if (this != null && isEmpty()) this else list

fun <K, V> Map<K, V>?.orElse(map : Map<K, V>) =
    if (this != null && isEmpty()) this else map