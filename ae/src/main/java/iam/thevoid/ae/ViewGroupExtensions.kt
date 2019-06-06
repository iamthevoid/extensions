package iam.thevoid.ae

import android.animation.LayoutTransition
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi

inline fun <reified T : View> ViewGroup.findView(): T? {
    for (i in 0 until childCount) {
        val view = getChildAt(i)
        if (view is T) {
            return view
        }
    }

    return null
}

@set:RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
var ViewGroup.animateLayoutChanges: Boolean
    set(value) {
        if (value) {
            layoutTransition = LayoutTransition().apply {
                disableTransitionType(LayoutTransition.DISAPPEARING)
            }
        } else {
            layoutTransition = null
        }
    }
    get() = layoutTransition != null