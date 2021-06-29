package iam.thevoid.ae

import android.animation.LayoutTransition
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi

inline fun <reified T : View> ViewGroup.findView(): List<T> {
    val list = mutableListOf<T>()
    for (i in 0 until childCount) {
        val view = getChildAt(i)
        if (view is T) {
            list.add(view)
        }
    }

    return list
}

@set:RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
var ViewGroup.animateLayoutChanges: Boolean
    set(value) {
        layoutTransition = if (value) {
            LayoutTransition().apply {
                disableTransitionType(LayoutTransition.DISAPPEARING)
            }
        } else {
            null
        }
    }
    get() = layoutTransition != null