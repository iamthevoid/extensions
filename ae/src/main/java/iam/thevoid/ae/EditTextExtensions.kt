package iam.thevoid.ae

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun EditText.requestSoftInput() {
    post {
        requestFocusFromTouch()
        (context.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.showSoftInput(this, 0)
    }
}

fun EditText.moveCursorToEnd() = setSelection(text.length)