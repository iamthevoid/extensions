package iam.thevoid.e

fun <T : Any> T?.orElse(item: T) =
    this ?: item

fun <T : Any> T?.or(item: T?) =
    this ?: item

@Deprecated("Use safe() with args instead")
fun <T : CharSequence> T?.orElse(item: T) =
    if (this != null && isNotBlank()) this else item

fun <T : CharSequence> T?.or(item: T?) =
    if (this != null && isNotBlank()) this else item

@Deprecated("Use safe() with args instead")
fun Byte?.orElse(byte: Byte) =
    if (this != null && this != 0.toByte()) this else byte

fun Byte?.or(byte: Byte?) =
    if (this != null && this != 0.toByte()) this else byte

@Deprecated("Use safe() with args instead")
fun Short?.orElse(short: Short) =
    if (this != null && this != 0.toShort()) this else short

fun Short?.or(short: Short?) =
    if (this != null && this != 0.toShort()) this else short

@Deprecated("Use safe() with args instead")
fun Int?.orElse(int : Int) =
    if (this != null && this != 0) this else int

fun Int?.or(int : Int?) =
    if (this != null && this != 0) this else int

@Deprecated("Use safe() with args instead")
fun Long?.orElse(long : Long) =
    if (this != null && this != 0L) this else long

fun Long?.or(long : Long?) =
    if (this != null && this != 0L) this else long

@Deprecated("Use safe() with args instead")
fun Float?.orElse(float : Float) =
    if (this != null && this != 0f) this else float

fun Float?.or(float : Float?) =
    if (this != null && this != 0f) this else float

@Deprecated("Use safe() with args instead")
fun Double?.orElse(double : Double) =
    if (this != null && this != 0.toDouble()) this else double

fun Double?.or(double : Double?) =
    if (this != null && this != 0.toDouble()) this else double

@Deprecated("Use safe() with args instead")
fun <T> List<T>?.orElse(list : List<T>) =
    if (this != null && isNotEmpty()) this else list

fun <T> List<T>?.or(list : List<T>?) =
    if (this != null && isNotEmpty()) this else list

@Deprecated("Use safe() with args instead")
fun <K, V> Map<K, V>?.orElse(map : Map<K, V>) =
    if (this != null && isNotEmpty()) this else map

fun <K, V> Map<K, V>?.or(map : Map<K, V>?) =
    if (this != null && isNotEmpty()) this else map