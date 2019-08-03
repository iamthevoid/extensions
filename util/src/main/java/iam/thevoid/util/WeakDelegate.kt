package iam.thevoid.util

import java.lang.ref.WeakReference
import kotlin.reflect.KProperty

class WeakDelegate<T> {

    private var reference: WeakReference<T> = WeakReference<T>(null)

    operator fun setValue(host: Any, property: KProperty<*>, newReference: T?) {
        reference = WeakReference<T>(newReference)
    }

    operator fun getValue(host: Any, property: KProperty<*>) = reference.get()
}