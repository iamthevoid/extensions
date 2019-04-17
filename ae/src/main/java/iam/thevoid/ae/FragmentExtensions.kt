package iam.thevoid.ae

import android.app.Activity
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.view.inputmethod.InputMethodManager
import androidx.annotation.*
import androidx.fragment.app.Fragment

/**
 * KEYBOARD
 */

fun Fragment?.hideKeyboard() {
    (this?.context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
            .toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
}

fun Fragment.showKeyboard() {
    (context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager)
            ?.also { inputMethodManager ->
                view?.rootView?.apply { post { inputMethodManager.showSoftInput(this, 0) } }
                        ?: inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            }
}

/**
 * RESOURSES
 */

fun Fragment.string(@StringRes res: Int, vararg obj: Any?): String = activity.string(res, *obj)

fun Fragment.color(@ColorRes res: Int): Int = activity.color(res)

inline fun <reified T : Number> Fragment.dimen(@DimenRes res: Int): T = activity.dimen(res)

@Deprecated("Use \"dimen(@DimenRes res: Int)\" instead", level = DeprecationLevel.WARNING)
fun Fragment.dimenPxSize(@DimenRes res: Int): Int = activity.dimen(res)

fun Fragment.drawable(@DrawableRes res: Int): Drawable? = activity.drawable(res)

fun Fragment.coloredDrawable(@DrawableRes res: Int, @ColorRes colorRes: Int): Drawable? = activity.coloredDrawable(res, colorRes)

fun Fragment.quantityString(@PluralsRes res : Int, quantity : Int, vararg args : Any?) = activity.quantityString(res, quantity, *args)

fun Fragment.quantityString(@PluralsRes res : Int, quantity : Int) = activity.quantityString(res, quantity)

/**
 * WINDOW
 */

val Fragment.statusBarHeight: Int
    get() = activity.statusBarHeight

@JvmOverloads
fun Fragment.getNavigationBarHeight(orientation: Int = Configuration.ORIENTATION_PORTRAIT): Int = activity.getNavigationBarHeight(orientation)

val Fragment.screenWidth
    get() = activity.screenWidth

val Fragment.screenHeight
    get() = activity.screenHeight

val Fragment.screenWidthDp
    get() = activity.screenWidthDp

val Fragment.screenHeightDp
    get() = activity.screenHeightDp

val Fragment.dp: Float
    get() = activity.dp