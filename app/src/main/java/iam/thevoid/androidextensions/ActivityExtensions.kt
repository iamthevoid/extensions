package iam.thevoid.androidextensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair

fun Activity.makeSceneTransitionAnimation(view: View, transitionName: String): ActivityOptionsCompat =
        ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, transitionName)

fun Activity.makeSceneTransitionAnimation(vararg elements: Pair<View, String>): ActivityOptionsCompat =
        ActivityOptionsCompat.makeSceneTransitionAnimation(this, *elements)


fun Activity?.hideKeyboard() {
    (this?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
            .toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
}

fun Activity?.showKeyboard() {
    (this?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
            .toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}