package iam.thevoid.ae

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair

fun Activity.makeSceneTransitionAnimation(view: View, transitionName: String): ActivityOptionsCompat =
    ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, transitionName)

fun Activity.makeSceneTransitionAnimation(vararg elements: Pair<View, String>): ActivityOptionsCompat =
    ActivityOptionsCompat.makeSceneTransitionAnimation(this, *elements)

fun Activity?.hideKeyboardForced() {
    this?.currentFocus?.let { currentFocus ->
        try {
            (currentFocus.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow(currentFocus.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        } catch (e: Exception) {
        }
    }
}

fun Activity?.hideKeyboard() {
    (this?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
        .toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
}

fun Activity?.showKeyboard() {
    (this?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
        .toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}