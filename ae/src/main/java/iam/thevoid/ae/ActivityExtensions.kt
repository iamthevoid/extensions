package iam.thevoid.ae

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair

fun Activity.makeSceneTransitionAnimation(view: View, transitionName: String): ActivityOptionsCompat =
    ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, transitionName)

fun Activity.makeSceneTransitionAnimation(vararg elements: Pair<View, String>): ActivityOptionsCompat =
    ActivityOptionsCompat.makeSceneTransitionAnimation(this, *elements)

fun Activity?.hideKeyboard() {
    this?.apply {
        (getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.hideSoftInputFromWindow(window.decorView.windowToken, InputMethodManager.HIDE_IMPLICIT_ONLY)
    }
}

fun Activity?.showKeyboard() {
    (this?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
        .toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

val Activity.view : View
    get() = (findViewById<ViewGroup>(android.R.id.content))