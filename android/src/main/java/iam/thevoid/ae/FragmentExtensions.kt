package iam.thevoid.ae

import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.*
import androidx.fragment.app.Fragment
import iam.thevoid.e.safe

/**
 * KEYBOARD
 */

@JvmOverloads
fun Fragment?.hideKeyboard(flag : Int = InputMethodManager.HIDE_IMPLICIT_ONLY) { this?.activity?.hideKeyboard(flag) }

@JvmOverloads
fun Fragment?.showKeyboard(showFlag : Int = InputMethodManager.SHOW_FORCED, hideFlag : Int = 0) { this?.activity?.toggleKeyboard(showFlag, hideFlag) }

/**
 * RESOURSES
 */

fun Fragment.string(@StringRes res: Int, vararg obj: Any?): String = activity.string(res, *obj)

fun Fragment.color(@ColorRes res: Int): Int = activity.color(res)

fun Fragment.integer(@IntegerRes res: Int): Int = activity.integer(res)

inline fun <reified T : Number> Fragment.dimen(@DimenRes res: Int): T = activity.dimen(res)

@Deprecated("Use \"dimen(@DimenRes res: Int)\" instead", level = DeprecationLevel.WARNING)
fun Fragment.dimenPxSize(@DimenRes res: Int): Int = activity.dimen(res)

fun Fragment.drawable(@DrawableRes res: Int): Drawable? = activity.drawable(res)

fun Fragment.coloredDrawable(@DrawableRes res: Int, @ColorRes colorRes: Int): Drawable? =
    activity.coloredDrawable(res, colorRes)

fun Fragment.quantityString(@PluralsRes res: Int, quantity: Int, vararg args: Any?) =
    activity.quantityString(res, quantity, *args)

fun Fragment.quantityString(@PluralsRes res: Int, quantity: Int) = activity.quantityString(res, quantity)

/**
 * WINDOW
 */


val Fragment.actionBarHeight
    get() = context?.let { dimen<Int>(it.actionBarSizeResource) }.safe()

val Fragment.statusBarHeight: Int
    get() = activity.statusBarHeight

@JvmOverloads
fun Fragment.getNavigationBarHeight(orientation: Int = Configuration.ORIENTATION_PORTRAIT): Int =
    activity.getNavigationBarHeight(orientation)

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

fun Fragment.colorString(@ColorRes res: Int) =
    context?.colorString(res) ?: activity?.colorString(res) ?: view?.colorString(res) ?: "#00000000"

/**
 * INFLATER
 */

val Fragment.inflater
    get() = activity?.inflater

@JvmOverloads
fun Fragment.inflate(@LayoutRes res: Int, root: ViewGroup? = null, attachToRoot: Boolean = false) =
    activity?.inflate(res, root, attachToRoot)